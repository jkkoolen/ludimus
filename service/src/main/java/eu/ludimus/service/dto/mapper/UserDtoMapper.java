package eu.ludimus.service.dto.mapper;

import eu.ludimus.domain.entity.User;
import eu.ludimus.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public User map(UserDto dto, User entity) {
        entity.setId(dto.getId());
        entity.setLastUpdated(dto.getLastUpdated());
        entity.setCreated(dto.getCreated());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setActive(dto.isActive());
        entity.setRole(dto.getRole());
        entity.setResetToken(dto.getResetToken());
        entity.setBank(dto.getBank());
        entity.setIban(dto.getIban());
        entity.setBic(dto.getBic());
        entity.setCoc(dto.getCoc());
        entity.setVatNumber(dto.getVatNumber());
        entity.setFullName(dto.getFullName());
        return entity;
    }

    /**
     *
     * @param entity
     * @return UserDto, can be null if entity is null
     */
    public UserDto map(User entity) {
        if(entity == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setLastUpdated(entity.getLastUpdated());
        dto.setCreated(entity.getCreated());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setActive(entity.isActive());
        dto.setRole(entity.getRole());
        dto.setResetToken(entity.getResetToken());
        dto.setBank(entity.getBank());
        dto.setIban(entity.getIban());
        dto.setBic(entity.getBic());
        dto.setCoc(entity.getCoc());
        dto.setVatNumber(entity.getVatNumber());
        dto.setFullName(entity.getFullName());

        return dto;
    }

}
