package eu.ludimus.service.hours;

import eu.ludimus.domain.entity.User;
import eu.ludimus.domain.entity.Action;
import eu.ludimus.service.dto.HoursDto;

public interface HoursService {
    HoursDto findById(Long id);
    HoursDto save(HoursDto hours, User user, Action action);
    void delete(HoursDto hours);
    HoursDto findStartedByUser(User user);
}
