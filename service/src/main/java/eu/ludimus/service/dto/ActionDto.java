package eu.ludimus.service.dto;

import java.util.Date;

public final class ActionDto {
    private Long id;
    private Date lastUpdated;
    private Date created;
    private String value;
    private UserDto userDto;
    private ActionDto actionDto;

    public Long getId() {
        return id;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public ActionDto getActionDto() {
        return actionDto;
    }

    public void setActionDto(ActionDto actionDto) {
        this.actionDto = actionDto;
    }
}
