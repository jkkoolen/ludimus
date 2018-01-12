package eu.ludimus.service;

import eu.ludimus.model.Ticket;
import eu.ludimus.model.User;
import eu.ludimus.redis.TicketRedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    private final Logger logger = LoggerFactory.getLogger(TicketService.class);
    @Autowired
    private TicketRedis ticketRedis;

    public List<Ticket> getAllTickets(final Long userId, final Date from, final Date to) {
        final User user = User.builder().build();
        user.setId(userId);
        return ticketRedis.findByUserAndTicketDateBetween(user, from, to);
    }

    public Ticket addTicket(final Ticket ticket) {
        return ticketRedis.save(ticket);
    }
 }
