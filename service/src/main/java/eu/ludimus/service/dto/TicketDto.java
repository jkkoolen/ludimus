package eu.ludimus.service.dto;

import eu.ludimus.service.dto.validation.CheckImage;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@CheckImage
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
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
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

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
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
