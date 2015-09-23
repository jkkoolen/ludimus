package eu.ludimus.service.ticket;

import eu.ludimus.service.dto.AddressDto;
import eu.ludimus.service.dto.TicketDto;
import eu.ludimus.service.dto.UserDto;

import java.util.Date;
import java.util.List;

public interface TicketService {
    TicketDto findById(Long id);
    TicketDto save(TicketDto ticket);
    void delete(TicketDto ticket);
    List<TicketDto> findBetweenTicketDate(UserDto user, Date from, Date to);
    AddressDto findByUser(UserDto user);
}
