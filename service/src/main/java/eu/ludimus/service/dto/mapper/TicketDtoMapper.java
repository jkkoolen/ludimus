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
        target.setId(source.id());
        target.setLastUpdated(source.lastUpdated());
        target.setCreated(source.created());
        target.setTicketDate(source.ticketDate());
        target.setInvoiceNumber(source.invoiceNumber());
        target.setDescription(source.description());
        target.setPrice(source.price());
        target.setVatRate(source.vatRate());
        target.setTicketImage(imageService.toJpg(source.ticketImage()));
        if(source.user() != null)
            target.setUser(userMapper.map(source.user(), target.getUser() == null ? new User() : target.getUser()));
        target.setIncome(source.income());
        if(source.forMonth() != null) {
            target.setForMonth(source.forMonth());
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

        target.id_$eq(source.getId());
        target.lastUpdated_$eq(source.getLastUpdated());
        target.created_$eq(source.getCreated());
        target.ticketDate_$eq(source.getTicketDate());
        target.invoiceNumber_$eq(source.getInvoiceNumber());
        target.description_$eq(source.getDescription());
        target.price_$eq(source.getPrice());
        target.vatRate_$eq(source.getVatRate());
        target.ticketImage_$eq(source.getTicketImage());
        target.user_$eq(userMapper.map(source.getUser()));
        target.income_$eq(source.isIncome());
        target.forMonth_$eq(source.getForMonth());
        return target;
    }

}
