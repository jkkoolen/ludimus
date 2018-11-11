package eu.ludimus.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.drive.model.File;
import eu.ludimus.googledrive.GoogleDriveUtil;
import eu.ludimus.model.ErrorInfo;
import eu.ludimus.model.Ticket;
import eu.ludimus.model.User;
import eu.ludimus.redis.UserRedis;
import eu.ludimus.properties.LudimusProperties;
import eu.ludimus.authorization.UserRequestUtil;
import eu.ludimus.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Slf4j
@RequestMapping("/ludimus")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserRedis userRedis;
    @Autowired
    private UserRequestUtil userRequestUtil;
    @Autowired
    private LudimusProperties ludimusProperties;

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static final SimpleDateFormat DATE_FORMAT_YEAR = new SimpleDateFormat("yyyy");
    private static final SimpleDateFormat DATE_FORMAT_MONTH = new SimpleDateFormat("MM");
    private static final SimpleDateFormat DATE_FORMAT_DAY = new SimpleDateFormat("dd");

    @CrossOrigin
    @RequestMapping(value = "/secure/overview", method = RequestMethod.GET)
    @ResponseBody
    public List<Ticket> getOverview(final @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date from,
                                    final @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date to) throws ParseException {
        log.info("getOverview with from : {} and to : {}", from, to);
        return ticketService.getAllTickets(userRequestUtil.getUser().getId(), from, to);
    }

    @RequestMapping(value = "/export", method = RequestMethod.PUT)
    @ResponseBody
    public List<String> export() {
        ArrayList<String> strings = new ArrayList<>();
        for(User u : userRedis.findAll()) {
            List<Ticket> allTickets = ticketService.getAllTickets(u.getId(),
                    Date.from(LocalDate.now().minusYears(5).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date());
            strings.addAll(allTickets.stream().map(tiket -> writeToFile(tiket, u)).collect(Collectors.toList()));
        }
        return strings;
    }

    private String writeToFile(Ticket ticket, User u) {
        FileOutputStream out = null;
        try {
            byte[] ticketImage = ticket.getTicketImage();
            ticket.resetImage();

            String fileNamePrefix = ludimusProperties.getDataDir() + '/'
                    + ticket.getClass().getSimpleName() + '/'
                    + u.getId() + '/'
                    + DATE_FORMAT_YEAR.format(ticket.getTicketDate()) + "/"
                    + DATE_FORMAT_MONTH.format(ticket.getTicketDate())  + '/'
                    + DATE_FORMAT_DAY.format(ticket.getTicketDate())  + '/';
            java.io.File file = new java.io.File(fileNamePrefix);
            if (!file.exists()) {
                file.mkdirs();
            }
            objectMapper.writeValue(new FileWriter(fileNamePrefix + ticket.getInvoiceNumber() + ".json"), ticket);
            if (ticketImage != null) {
                out = new FileOutputStream(fileNamePrefix + ticket.getInvoiceNumber() + ".jpg");
                out.write(ticketImage);
                out.flush();
                out.close();
            }
        } catch(IOException e) {
            log.warn(e.getMessage(), e);
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch(Exception e) {
                    //empty
                }
            }

        }
        return ticket.getInvoiceNumber();
    }

    @CrossOrigin
    @RequestMapping(value = "/secure/addTicket", method = RequestMethod.POST)
    @ResponseBody
    public Ticket addTicket(final @RequestBody Ticket ticket) {
        ticket.setUser(userRequestUtil.getUser());
        return ticketService.addTicket(ticket);
    }

    @CrossOrigin
    @RequestMapping(value = "/secure/deleteTicket", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean deleteTicket(final @RequestParam Long ticketId) {
        return ticketService.deleteTicket(userRequestUtil.getUser(), ticketId);
    }

    @CrossOrigin
    @RequestMapping(value = "/secure/getFilesUploadedInTheLastNDays", method = RequestMethod.GET)
    @ResponseBody
    public List<File> getFilesUploadedInTheLastNDays(final @RequestParam int dayCount) throws IOException {
        User user = userRequestUtil.getUser();
        if(user == null) {
            return Collections.emptyList();
        }
        return GoogleDriveUtil.getFilesUploadedInTheLastNDaysBy(dayCount, user.getEmail());
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo invalid(final IOException e) {
        return new ErrorInfo("TICKET_ERROR", e.getMessage());

    }

}
