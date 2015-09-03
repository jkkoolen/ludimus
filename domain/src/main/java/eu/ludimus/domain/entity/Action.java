package eu.ludimus.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "action")
@Data
public class Action extends BaseEntity {
    private static final long serialVersionUID = 3414351779482695692L;
    @Column(name = "value")
    private String value;

    @JoinColumn(name = "user_id")
   	@ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Action() {
        //empty
    }
}
