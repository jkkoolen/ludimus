package eu.ludimus.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name="user")
@Data
public class User extends BaseEntity {
	private static final long serialVersionUID = 7502572550789966378L;
    public enum Role {
        ROLE_ADMIN,
        ROLE_USER
    }

	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "active")
	private boolean active;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    
    @Column(name = "reset_token")
    private String resetToken;

}
