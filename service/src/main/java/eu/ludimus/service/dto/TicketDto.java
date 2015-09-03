package eu.ludimus.service.dto;

import eu.ludimus.service.dto.validation.CheckImage;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@CheckImage
@Data
public class TicketDto {
    private Long id;
    private Date lastUpdated;
    private Date created;
    @NotNull
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date ticketDate;
    @NotEmpty
    private String invoiceNumber;
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal vatRate;
    private byte[] ticketImage;
    private boolean income;

    @NotNull
    @Valid
    private UserDto user = new UserDto();
    private Integer forMonth;
}
