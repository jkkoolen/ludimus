package eu.ludimus.service.dto.mapper;

import eu.ludimus.domain.entity.Action;
import eu.ludimus.domain.entity.User;
import eu.ludimus.service.dto.ActionDto;
import org.springframework.stereotype.Component;

@Component
public class ActionDtoMapper {
    private UserDtoMapper userMapper = new UserDtoMapper();

    public Action map(ActionDto source, Action target) {
        target.setId(source.getId());
        target.setLastUpdated(source.getLastUpdated());
        target.setCreated(source.getCreated());
        target.setValue(source.getValue());
        target.setUser(userMapper.map(source.getUserDto(), target.getUser() == null ? new User() : target.getUser()));
        return target;
    }

    public ActionDto map(Action source) {
        ActionDto target = new ActionDto();
        target.setId(source.getId());
        target.setLastUpdated(source.getLastUpdated());
        target.setCreated(source.getCreated());
        target.setValue(source.getValue());
        target.setUserDto(userMapper.map(source.getUser()));
        return target;
    }
}
