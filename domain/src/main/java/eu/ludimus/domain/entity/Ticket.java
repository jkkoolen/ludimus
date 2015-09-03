package eu.ludimus.domain.entity;

import javax.persistence.*;
import java.math.*;
import java.util.*;

@Entity
@Table(name = "ticket")
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
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setTicketImage(byte[] ticketImage) {
        this.ticketImage = ticketImage;
    }

    public byte[] getTicketImage() {
        return ticketImage;
    }
	public Date getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

    public boolean isIncome() {
        return income;
    }

    public void setIncome(boolean income) {
        this.income = income;
    }

    public Integer getForMonth() {
        return forMonth;
    }

    public void setForMonth(Integer forMonth) {
        this.forMonth = forMonth;
    }
}
