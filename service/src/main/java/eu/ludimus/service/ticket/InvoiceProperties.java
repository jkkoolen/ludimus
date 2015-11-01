package eu.ludimus.service.ticket;

import eu.ludimus.service.dto.AddressDto;
import eu.ludimus.service.dto.UserDto;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class InvoiceProperties {
    @NotEmpty
    private String invoiceNumber;
    private Date invoiceDate;
    @NotNull
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date endPeriod;
    @NotEmpty
    private String description;
    @NotNull
    @NumberFormat(pattern = "####,##")
    private Double units;
    @NotNull
    @NumberFormat(pattern = "####,##")
    private Double fare;
    @NotNull
    private UserDto user;
    @NotNull
    private AddressDto address;

    public InvoiceProperties() {
        invoiceDate = new Date();
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public Double getNet() {
        return fare * units;
    }

    public Double getVat() {
        return fare * units * .21;
    }

    public Double getGross() {
        return getNet() + getVat();
    }
    public String getName() {
        return user.getFullName();
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getStreetNumber() {
        return address.getStreetNumber();
    }

    public String getPostalcode() {
        return address.getPostalcode();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }

    public long getCoc() {
        return user.getCoc();
    }

    public String getVatNumber() {
        return user.getVatNumber();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getBank() {
        return user.getBank();
    }

    public String getIBAN() {
        return user.getIban();
    }

    public String getBIC() {
        return user.getBic();
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
