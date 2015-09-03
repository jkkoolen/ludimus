package eu.ludimus.domain.entity;

import javax.persistence.*;
import java.util.*;
import java.sql.Time;

@Entity
@Table(name = "hours")
public class Hours extends BaseEntity {

    private static final long serialVersionUID = -3776712789057811601L;
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JoinColumn(name = "action_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Action action;

    @Column(name = "date")
    private Date date;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    public Hours() {
        //empty
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Action getAction()
    {
        return action;
    }

    public void setAction(Action action)
    {
        this.action = action;
    }
}
