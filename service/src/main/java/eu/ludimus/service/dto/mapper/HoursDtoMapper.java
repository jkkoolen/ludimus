package eu.ludimus.service.dto.mapper;

import eu.ludimus.domain.entity.Action;
import eu.ludimus.domain.entity.Hours;
import eu.ludimus.domain.entity.User;
import eu.ludimus.service.dto.HoursDto;
import org.springframework.stereotype.Component;

@Component
public class HoursDtoMapper {
    private UserDtoMapper userMapper = new UserDtoMapper();
    private ActionDtoMapper actionDtoMapper = new ActionDtoMapper();
    public Hours map(HoursDto source, Hours target) {
        target.setId(source.getId());
        target.setLastUpdated(source.getLastUpdated());
        target.setCreated(source.getCreated());
        target.setUser(userMapper.map(source.getUserDto(), target.getUser() == null ? new User() : target.getUser()));
        target.setAction(actionDtoMapper.map(source.getActionDto(), target.getAction() == null ? new Action() : target.getAction()));
        target.setDate(source.getDate());
        target.setStartTime(source.getStartTime());
        target.setEndTime(source.getEndTime());
        return target;
    }

    public HoursDto map(Hours source) {
        HoursDto target = new HoursDto();
        if(source == null)
            return target;
        target.setId(source.getId());
        target.setLastUpdated(source.getLastUpdated());
        target.setCreated(source.getCreated());
        target.setUserDto(userMapper.map(source.getUser()));
        target.setActionDto(actionDtoMapper.map(source.getAction()));
        target.setDate(source.getDate());
        target.setStartTime(source.getStartTime());
        target.setEndTime(source.getEndTime());
        return target;
    }

}
