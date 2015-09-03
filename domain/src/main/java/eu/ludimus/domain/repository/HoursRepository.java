package eu.ludimus.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import eu.ludimus.domain.entity.*;

public interface HoursRepository extends PagingAndSortingRepository<Hours, Long> {
    Hours findById(Long id);
    Hours findByUserIdAndStartTimeIsNotNullAndEndTimeIsNull(Long userId);
}
