package eu.ludimus.service.dto.mapper;

import com.itextpdf.text.pdf.codec.Base64;
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
    private UserDtoMapper userDtoMapper = new UserDtoMapper();

    /**
     * user will not be mapped.
     * @param dto to be mapped
     * @param entity to which it will be mapped
     * @return Ticket
     */
    public Ticket map(TicketDto dto, Ticket entity) {
        if(entity == null) {
            entity = new Ticket();
        }
        if(dto == null) {
            return entity;
        }
        entity.setId(dto.getId());
        entity.setLastUpdated(dto.getLastUpdated());
        entity.setCreated(dto.getCreated());
        entity.setTicketDate(dto.getTicketDate());
        entity.setInvoiceNumber(dto.getInvoiceNumber());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setVatRate(dto.getVatRate());
        entity.setTicketImage(imageService.toJpg(dto.getTicketImage()));
        if(dto.getUser() != null) {
            entity.setUser(userDtoMapper.map(dto.getUser(), entity.getUser() == null ? new User() : entity.getUser()));
        }
        entity.setIncome(dto.isIncome());
        if(dto.getForMonth() != null) {
            entity.setForMonth(dto.getForMonth());
        }
        return entity;
    }

    /**
     *
     * @param entity to map from
     * @return TicketDto, can be null if entity is null
     */
    public TicketDto map(Ticket entity) {
        if(entity == null) {
            return null;
        }
        TicketDto dto = new TicketDto();
        dto.setId(entity.getId());
        dto.setLastUpdated(entity.getLastUpdated());
        dto.setCreated(entity.getCreated());
        dto.setTicketDate(entity.getTicketDate());
        dto.setInvoiceNumber(entity.getInvoiceNumber());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setVatRate(entity.getVatRate());
        if(entity.getTicketImage() != null) {
            dto.setBase64Image(Base64.encodeBytes(entity.getTicketImage()).replaceAll("\n",""));
        }
        dto.setUser(userDtoMapper.map(entity.getUser()));
        dto.setIncome(entity.isIncome());
        dto.setForMonth(entity.getForMonth());
        return dto;
    }

}
