package eu.ludimus.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "action")
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
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
