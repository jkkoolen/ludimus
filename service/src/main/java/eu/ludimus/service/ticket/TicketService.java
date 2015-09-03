package eu.ludimus.service.ticket;

import eu.ludimus.domain.entity.User;
import eu.ludimus.service.dto.TicketDto;
import java.util.Date;
import java.util.List;

public interface TicketService {
    TicketDto findById(Long id);
    TicketDto save(TicketDto ticket);
    void delete(TicketDto ticket);
    List<TicketDto> findBetweenTicketDate(User user, Date from, Date to);
}
