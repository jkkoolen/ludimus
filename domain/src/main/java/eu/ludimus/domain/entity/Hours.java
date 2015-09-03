package eu.ludimus.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;
import java.sql.Time;

@Entity
@Table(name = "hours")
@Data
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
}
