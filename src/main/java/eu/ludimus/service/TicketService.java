package eu.ludimus.service;

import eu.ludimus.model.Ticket;
import eu.ludimus.model.User;
import eu.ludimus.redis.TicketRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
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

    public Boolean deleteTicket(final User user, final Long ticketId) {
        return ticketRedis.delete(user, ticketId);
    }
}
