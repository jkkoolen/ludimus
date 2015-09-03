package eu.ludimus.service.dto;

import eu.ludimus.domain.entity.User.Role;
import java.util.*;

public final class UserDto {
    private Long id;
    private Date lastUpdated;
    private Date created;
    private String name;
    private String password;
    private boolean active;
    private Role role;
    private String resetToken;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getResetToken() {
        return resetToken;
    }

}
