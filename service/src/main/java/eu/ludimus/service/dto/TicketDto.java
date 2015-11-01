package eu.ludimus.service.dto;

import eu.ludimus.service.dto.validation.CheckImage;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Arrays;
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
    @NumberFormat(pattern = "####,##")
    private BigDecimal price;
    @NotNull
    private BigDecimal vatRate;
    private byte[] ticketImage;
    private boolean income;
    private String base64Image;

    @NotNull
    @Valid
    private UserDto user = new UserDto();
    private Integer forMonth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
    }

    public byte[] getTicketImage() {
        return ticketImage;
    }

    public void setTicketImage(byte[] ticketImage) {
        this.ticketImage = ticketImage;
    }

    public boolean isIncome() {
        return income;
    }

    public void setIncome(boolean income) {
        this.income = income;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Integer getForMonth() {
        return forMonth;
    }

    public void setForMonth(Integer forMonth) {
        this.forMonth = forMonth;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", lastUpdated=" + lastUpdated +
                ", created=" + created +
                ", ticketDate=" + ticketDate +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vatRate=" + vatRate +
                ", ticketImage=" + Arrays.toString(ticketImage) +
                ", income=" + income +
                ", base64Image='" + base64Image + '\'' +
                ", user=" + user +
                ", forMonth=" + forMonth +
                '}';
    }
}
