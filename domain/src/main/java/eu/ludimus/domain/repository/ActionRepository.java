package eu.ludimus.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import eu.ludimus.domain.entity.*;

public interface ActionRepository extends PagingAndSortingRepository<Action, Long> {
    Action findById(Long id);
}
