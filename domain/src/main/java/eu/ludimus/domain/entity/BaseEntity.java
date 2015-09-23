package eu.ludimus.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 2369950228434785069L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "last_updated")
    private Date lastUpdated;

    @Column(name = "created")
    private Date created;

	public Long getId() {
		return id;
	}
	
    @PreUpdate
    public void preUpdate() {
    	lastUpdated = new Date();
    }
     
    @PrePersist
    public void prePersist() {
        Date now = new Date();
        created = now;
        lastUpdated = now;
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
}
