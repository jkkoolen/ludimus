package eu.ludimus.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import eu.ludimus.model.deserializer.KmrDeserializer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kmr")
@JsonDeserialize(using = KmrDeserializer.class)
public class Kmr extends BaseEntity {
    private static final long serialVersionUID = 4757970653858900847L;

    @Column(name = "day")
    private Date day;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "is_business")
    private boolean isBusiness;

    @Column(name = "start_total")
    private Integer startTotal;

    @Column(name = "end_total")
    private Integer endTotal;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Kmr() {
        //empty
    }

    public Date getDay() {
        return day;
    }

    public Kmr setDay(Date day) {
        this.day = day;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public Kmr setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public Kmr setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public Kmr setBusiness(boolean business) {
        isBusiness = business;
        return this;
    }

    public Integer getStartTotal() {
        return startTotal;
    }

    public Kmr setStartTotal(Integer startTotal) {
        this.startTotal = startTotal;
        return this;
    }

    public Integer getEndTotal() {
        return endTotal;
    }

    public Kmr setEndTotal(Integer endTotal) {
        this.endTotal = endTotal;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Kmr setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + "---> Kmr{" +
                "day=" + day +
                ", from='" + origin + '\'' +
                ", to='" + destination + '\'' +
                ", isBusiness=" + isBusiness +
                ", startTotal=" + startTotal +
                ", endTotal=" + endTotal +
                ", user=" + user +
                '}';
    }
}
