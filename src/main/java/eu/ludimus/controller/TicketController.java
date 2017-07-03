package eu.ludimus.controller;

import eu.ludimus.model.Ticket;
import eu.ludimus.model.User;
import eu.ludimus.service.Auth0Service;
import eu.ludimus.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private Auth0Service auth0Service;
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private static Logger logger = LoggerFactory.getLogger(TicketService.class);


    @CrossOrigin
    @RequestMapping(value = "/ludimus/overview", method = RequestMethod.GET)
    @ResponseBody
    public List<Ticket> getOverview(final HttpServletRequest request, final @RequestParam String from, final @RequestParam String to) throws ParseException {
        logger.info("getOverview with from : {} and to : {}", from, to);
        return ticketService.getAllTickets(auth0Service.idFromAuthorizationHeader(request.getHeader("Authorization")), DATE_FORMAT.parse(from), DATE_FORMAT.parse(to));
    }

    @CrossOrigin
    @RequestMapping(value = "/ludimus/addTicket", method = RequestMethod.POST)
    @ResponseBody
    public Ticket addTicket(final HttpServletRequest request, final @RequestBody Ticket ticket) {
        final User user = new User();
        user.setId(auth0Service.idFromAuthorizationHeader(request.getHeader("Authorization")));
        ticket.setUser(user);
        return ticketService.addTicket(ticket);
    }

}
