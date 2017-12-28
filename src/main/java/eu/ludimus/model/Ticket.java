package eu.ludimus.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import eu.ludimus.model.deserializer.TicketDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ticket")
@JsonDeserialize(using = TicketDeserializer.class)
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    
    @Column(name = "carcost")
    private boolean carcost;

    @JoinColumn(name = "user_id")
   	@ManyToOne(fetch = FetchType.EAGER)
    @Setter
    private User user;

    @Column(name = "for_month")
    private Integer forMonth;

    @Column(name = "depreciation_years")
    private Integer depreciationYears;

    @Column(name = "year_of_entry")
    private Integer yearOfEntry;

//    public Date getTicketDate() {
//        return ticketDate;
//    }
//
//    public Ticket setTicketDate(Date ticketDate) {
//        this.ticketDate = ticketDate;
//        return this;
//    }
//
//    public String getInvoiceNumber() {
//        return invoiceNumber;
//    }
//
//    public Ticket setInvoiceNumber(String invoiceNumber) {
//        this.invoiceNumber = invoiceNumber;
//        return this;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public Ticket setDescription(String description) {
//        this.description = description;
//        return this;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public Ticket setPrice(BigDecimal price) {
//        this.price = price;
//        return this;
//    }
//
//    public BigDecimal getVatRate() {
//        return vatRate;
//    }
//
//    public Ticket setVatRate(BigDecimal vatRate) {
//        this.vatRate = vatRate;
//        return this;
//    }
//
//    public byte[] getTicketImage() {
//        return ticketImage;
//    }
//
//    public Ticket setTicketImage(byte[] ticketImage) {
//        this.ticketImage = ticketImage;
//        return this;
//    }
//
//    public boolean isIncome() {
//        return income;
//    }
//
//    public Ticket setIncome(boolean income) {
//        this.income = income;
//        return this;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public Ticket setUser(User user) {
//        this.user = user;
//        return this;
//    }
//
//    public Integer getForMonth() {
//        return forMonth;
//    }
//
//    public Ticket setForMonth(Integer forMonth) {
//        this.forMonth = forMonth;
//        return this;
//    }
//
//    public boolean isCarcost() {
//        return carcost;
//    }
//
//    public Ticket setCarcost(boolean carcost) {
//        this.carcost = carcost;
//        return this;
//    }
//
//    public Integer getDepreciationYears() {
//        return depreciationYears;
//    }
//
//    public Ticket setDepreciationYears(Integer depreciationYears) {
//        this.depreciationYears = depreciationYears;
//        return this;
//    }
//
//    public Integer getYearOfEntry() {
//        return yearOfEntry;
//    }
//
//    public Ticket setYearOfEntry(Integer yearOfEntry) {
//        this.yearOfEntry = yearOfEntry;
//        return this;
//    }

//    @Override
//    public String toString() {
//        return super.toString() + " ---> Ticket{" +
//                "ticketDate=" + ticketDate +
//                ", invoiceNumber='" + invoiceNumber + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                ", vatRate=" + vatRate +
//                ", ticketImage=" + Arrays.toString(ticketImage) +
//                ", income=" + income +
//                ", carcost=" + carcost +
//                ", user=" + user +
//                ", forMonth=" + forMonth +
//                '}';
//    }
}
