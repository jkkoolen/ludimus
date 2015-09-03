package eu.ludimus.service.authentication;

import eu.ludimus.domain.entity.User;
import eu.ludimus.service.dto.UserDto;
import eu.ludimus.service.dto.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class LudimusSecurityContext {
    @Autowired
    private UserDtoMapper userDtoMapper;

    public final User getUser() {
        final LudimusUserDetails details = getDetails();
        return details == null ? null : details.getUser();
    }

    public final UserDto getUserDto() {
        return userDtoMapper.map(getUser());
    }

    private LudimusUserDetails getDetails() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal instanceof LudimusUserDetails ? (LudimusUserDetails) principal : null;
    }
}
