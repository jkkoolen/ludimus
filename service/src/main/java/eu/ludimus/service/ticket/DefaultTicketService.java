package eu.ludimus.service.ticket;

import eu.ludimus.domain.entity.Address;
import eu.ludimus.domain.entity.Ticket;
import eu.ludimus.domain.entity.User;
import eu.ludimus.domain.repository.AddressRepository;
import eu.ludimus.domain.repository.TicketRepository;
import eu.ludimus.domain.repository.UserRepository;
import eu.ludimus.service.dto.AddressDto;
import eu.ludimus.service.dto.TicketDto;
import eu.ludimus.service.dto.UserDto;
import eu.ludimus.service.dto.mapper.AddressDtoMapper;
import eu.ludimus.service.dto.mapper.TicketDtoMapper;
import eu.ludimus.service.pdf.PdfConverter;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public final class DefaultTicketService implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketDtoMapper ticketDtoMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PdfConverter pdfConverter;
    @Autowired
    private AddressDtoMapper addressDtoMapper;

    @Transactional(readOnly = true)
    @Override
    public TicketDto findById(Long id) {
        return ticketDtoMapper.map(ticketRepository.findById(id));
    }

    @Transactional(readOnly = false)
    @Override
    public TicketDto save(TicketDto ticketDto) {
        return ticketDtoMapper.map(ticketRepository.save(ticketDtoMapper.map(ticketDto, new Ticket())));
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(TicketDto ticket) {
        ticketRepository.delete(ticketDtoMapper.map(ticket, new Ticket()));
    }

	@Override
    @Transactional(readOnly = true)
	public List<TicketDto> findBetweenTicketDate(UserDto user, Date from, Date to) {
        to = DateUtils.truncate(to, Calendar.DATE);
        final User u = new User();
        u.setId(user.getId());
        List<Ticket> tickets = ticketRepository.findByUserAndTicketDateBetween(u, from, to);
		List<TicketDto> ticketDtos = new ArrayList<TicketDto>();
		for(Ticket t : tickets)
			ticketDtos.add(ticketDtoMapper.map(t));
		return ticketDtos;
	}

    @Override
    public AddressDto findByUser(UserDto user) {
        final User u = new User();
        u.setId(user.getId());
        final Address address = addressRepository.findByUser(u);
        return addressDtoMapper.map(address);
    }

}
