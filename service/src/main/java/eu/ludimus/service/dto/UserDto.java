package eu.ludimus.service.dto;

import eu.ludimus.domain.entity.User.Role;
import lombok.Data;

import java.util.*;

@Data
public final class UserDto {
    private Long id;
    private Date lastUpdated;
    private Date created;
    private String name;
    private String password;
    private boolean active;
    private Role role;
    private String resetToken;
}
