package eu.ludimus.service.dto.mapper;

import eu.ludimus.domain.entity.User;
import eu.ludimus.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public User map(UserDto source, User target) {
        target.setId(source.getId());
        target.setLastUpdated(source.getLastUpdated());
        target.setCreated(source.getCreated());
        target.setName(source.getName());
        target.setPassword(source.getPassword());
        target.setActive(source.active());
        target.setRole(source.getRole());
        target.setResetToken(source.getResetToken());
        return target;
    }

    /**
     *
     * @param source
     * @return UserDto, can be null if source is null
     */
    public UserDto map(User source) {
        if(source == null) {
            return null;
        }
        UserDto target = new UserDto();
        target.id_$eq(source.getId());
        target.setLastUpdated(source.getLastUpdated());
        target.setCreated(source.getCreated());
        target.setName(source.getName());
        target.setPassword(source.getPassword());
        target.setActive(source.isActive());
        target.setRole(source.getRole());
        target.setResetToken(source.getResetToken());
        return target;
    }

}
