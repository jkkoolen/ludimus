package eu.ludimus.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 2369950228434785069L;

    private Long id;
    
    private Date lastUpdated;

    private Date created;

    public void preUpdate() {
    	lastUpdated = new Date();
    }
     
    public void prePersist() {
        Date now = new Date();
        created = now;
        lastUpdated = now;
    }
}
