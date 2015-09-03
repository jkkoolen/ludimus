package eu.ludimus.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
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
}
