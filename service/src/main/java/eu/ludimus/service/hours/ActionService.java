package eu.ludimus.service.hours;

import eu.ludimus.domain.entity.Action;

public interface ActionService {
    Action findById(Long id);
    Action save(Action action);
    void delete(Action action);
}
