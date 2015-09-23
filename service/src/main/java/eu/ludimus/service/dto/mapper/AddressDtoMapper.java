package eu.ludimus.service.dto.mapper;

import eu.ludimus.domain.entity.Address;
import eu.ludimus.domain.entity.User;
import eu.ludimus.service.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoMapper {
    @Autowired
    private UserDtoMapper userDtoMapper;

    public Address map(AddressDto dto, Address entity) {
        if (entity == null) {
            entity = new Address();
        }
        if (dto == null) {
            return entity;
        }
        if (dto.getUser() != null) {
            entity.setUser(userDtoMapper.map(dto.getUser(), entity.getUser() == null ? new User() : entity.getUser()));
        }
        entity.setStreet(dto.getStreet());
        entity.setStreetNumber(dto.getStreetNumber());
        entity.setPostalcode(dto.getPostalcode());
        entity.setCity(dto.getCity());
        return entity;
    }

    public AddressDto map(Address entity) {
        final AddressDto dto = new AddressDto();
        if(entity == null) {
            return dto;
        }
        dto.setUser(userDtoMapper.map(entity.getUser()));
        dto.setStreet(entity.getStreet());
        dto.setStreetNumber(entity.getStreetNumber());
        dto.setPostalcode(entity.getPostalcode());
        dto.setCity(entity.getCity());
        return dto;
    }
}
