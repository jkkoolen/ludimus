package eu.ludimus.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name="user")
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

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
}
