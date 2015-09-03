package eu.ludimus.service.hours;

import eu.ludimus.domain.entity.*;
import eu.ludimus.domain.repository.*;
import java.lang.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public final class DefaultActionService implements ActionService {
    @Autowired
    private ActionRepository actionRepository;

    @Transactional(readOnly = true)
    @Override
    public Action findById(Long id) {
        return actionRepository.findById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public Action save(Action action) {
        return actionRepository.save(action);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Action action) {
        actionRepository.delete(action);
    }
}
