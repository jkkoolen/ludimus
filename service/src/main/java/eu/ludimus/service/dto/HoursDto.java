package eu.ludimus.service.dto;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public final class HoursDto {
    private Long id;
    private Date lastUpdated;
    private Date created;
    private UserDto userDto;
    private ActionDto actionDto;

    private Date date;
    private Time startTime;
    private Time endTime;
}
