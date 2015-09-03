package eu.ludimus.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import eu.ludimus.domain.entity.*;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {
    Ticket findById(Long id);
    List<Ticket> findByUserAndTicketDateBetween(User user, Date from, Date to);
}
