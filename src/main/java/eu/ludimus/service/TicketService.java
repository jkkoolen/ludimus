package eu.ludimus.service;

import eu.ludimus.model.Ticket;
import eu.ludimus.model.TicketRepository;
import eu.ludimus.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;

@Service
public class TicketService {
    private final Logger logger = LoggerFactory.getLogger(TicketService.class);
    @Autowired
    private TicketRepository ticketRepository;

    @Transactional(readOnly = true)
    public List<Ticket> getAllTickets(final Long userId, final Date from, final Date to) {
        final User user = new User();
        user.setId(userId);
        return ticketRepository.findByUserAndTicketDateBetween(user, from, to);
    }

    @Transactional
    public Ticket addTicket(final Ticket ticket) {
        return ticketRepository.save(ticket);
    }
 }
