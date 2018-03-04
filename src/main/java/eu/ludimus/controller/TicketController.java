package eu.ludimus.controller;

import com.google.api.services.drive.model.File;
import eu.ludimus.exception.InvalidException;
import eu.ludimus.googledrive.GoogleDriveUtil;
import eu.ludimus.model.ErrorInfo;
import eu.ludimus.model.Ticket;
import eu.ludimus.model.User;
import eu.ludimus.security.UserRequestUtil;
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

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@RestController
@Slf4j
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserRequestUtil userRequestUtil;

    @CrossOrigin
    @RequestMapping(value = "/ludimus/overview", method = RequestMethod.GET)
    @ResponseBody
    public List<Ticket> getOverview(final @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date from,
                                    final @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date to) throws ParseException {
        log.info("getOverview with from : {} and to : {}", from, to);
        return ticketService.getAllTickets(userRequestUtil.getUser().getId(), from, to);
    }

    @CrossOrigin
    @RequestMapping(value = "/ludimus/addTicket", method = RequestMethod.POST)
    @ResponseBody
    public Ticket addTicket(final @RequestBody Ticket ticket) {
        ticket.setUser(userRequestUtil.getUser());
        return ticketService.addTicket(ticket);
    }

    @CrossOrigin
    @RequestMapping(value = "/ludimus/getFilesUploadedInTheLastNDays", method = RequestMethod.GET)
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
