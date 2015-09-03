package eu.ludimus.service.dto;

import java.sql.Time;
import java.util.Date;

public final class HoursDto {
    private Long id;
    private Date lastUpdated;
    private Date created;
    private UserDto userDto;
    private ActionDto actionDto;

    private Date date;
    private Time startTime;
    private Time endTime;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public UserDto getUserDto()
    {
        return userDto;
    }

    public void setUserDto(UserDto userDto)
    {
        this.userDto = userDto;
    }

    public ActionDto getActionDto()
    {
        return actionDto;
    }

    public void setActionDto(ActionDto actionDto)
    {
        this.actionDto = actionDto;
    }
}
