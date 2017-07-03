package eu.ludimus.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {
    Ticket findById(Long id);
    List<Ticket> findByUserAndTicketDateBetween(User user, Date from, Date to);
}
