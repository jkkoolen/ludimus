package eu.ludimus.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.*;
import java.util.*;

@Entity
@Table(name = "ticket")
@Data
public class Ticket extends BaseEntity {
	private static final long serialVersionUID = 250810041693439624L;

	@Column(name = "ticket_date")
	private Date ticketDate;
	
    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "vat_rate")
    private BigDecimal vatRate;

    @Column(name = "ticket_image")
    private byte[] ticketImage;

    @Column(name = "income")
    private boolean income;
    
    @JoinColumn(name = "user_id")
   	@ManyToOne(fetch = FetchType.EAGER)
    private User user;


    @Column(name = "for_month")
    private Integer forMonth;

    public Ticket() {
        //empty
    }
}
