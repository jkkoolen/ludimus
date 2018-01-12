package eu.ludimus.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import eu.ludimus.model.deserializer.TicketDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@JsonDeserialize(using = TicketDeserializer.class)
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket extends BaseEntity {
	private static final long serialVersionUID = 250810041693439624L;

	private Date ticketDate;
	
    private String invoiceNumber;

    private String description;

    private BigDecimal price;

    private BigDecimal vatRate;

    private byte[] ticketImage;

    private boolean income;
    
    private boolean carcost;

    @Setter
    private User user;

    private Integer forMonth;

    private Integer depreciationYears;

    private Integer yearOfEntry;
}
