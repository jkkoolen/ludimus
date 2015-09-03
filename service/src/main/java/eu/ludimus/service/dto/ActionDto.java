package eu.ludimus.service.dto;

import lombok.Data;

import java.util.Date;

@Data
public final class ActionDto {
    private Long id;
    private Date lastUpdated;
    private Date created;
    private String value;
    private UserDto userDto;
    private ActionDto actionDto;
}
