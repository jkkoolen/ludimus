package eu.ludimus.service.dto.mapper;

import eu.ludimus.domain.entity.Ticket;
import eu.ludimus.domain.entity.User;
import eu.ludimus.service.dto.TicketDto;
import eu.ludimus.service.utils.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoMapper {
	@Autowired
	private ImageService imageService;
    private UserDtoMapper userMapper = new UserDtoMapper();

    /**
     * user will not be mapped.
     * @param source to be mapped
     * @param target to which it will be mapped
     * @return Ticket
     */
    public Ticket map(TicketDto source, Ticket target) {
        target.setId(source.getId());
        target.setLastUpdated(source.getLastUpdated());
        target.setCreated(source.getCreated());
        target.setTicketDate(source.getTicketDate());
        target.setInvoiceNumber(source.getInvoiceNumber());
        target.setDescription(source.getDescription());
        target.setPrice(source.getPrice());
        target.setVatRate(source.getVatRate());
        target.setTicketImage(imageService.toJpg(source.getTicketImage()));
        if(source.getUser() != null)
            target.setUser(userMapper.map(source.getUser(), target.getUser() == null ? new User() : target.getUser()));
        target.setIncome(source.isIncome());
        if(source.getForMonth() != null) {
            target.setForMonth(source.getForMonth());
        }
        return target;
    }

    /**
     *
     * @param source to map from
     * @return TicketDto, can be null if source is null
     */
    public TicketDto map(Ticket source) {
        if(source == null) {
            return null;
        }
        TicketDto target = new TicketDto();
        target.setId(source.getId());
        target.setLastUpdated(source.getLastUpdated());
        target.setCreated(source.getCreated());
        target.setTicketDate(source.getTicketDate());
        target.setInvoiceNumber(source.getInvoiceNumber());
        target.setDescription(source.getDescription());
        target.setPrice(source.getPrice());
        target.setVatRate(source.getVatRate());
        target.setTicketImage(source.getTicketImage());
        target.setUser(userMapper.map(source.getUser()));
        target.setIncome(source.isIncome());
        target.setForMonth(source.getForMonth());
        return target;
    }

}
