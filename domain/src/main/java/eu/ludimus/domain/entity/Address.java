package eu.ludimus.domain.entity;

import javax.persistence.*;

@Entity(name="address")
public class Address extends BaseEntity {
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(name="street",length = 80)
    private String street;

    @Column(name="street_number", length = 20)
    private String streetNumber;

    @Column(name="postalcode", length = 20)
    private String postalcode;

    @Column(name="city", length = 80)
    private String city;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
