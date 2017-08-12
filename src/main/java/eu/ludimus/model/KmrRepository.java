package eu.ludimus.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface KmrRepository extends PagingAndSortingRepository<Kmr, Long> {
    Kmr findById(Long id);
    List<Kmr> findByUserAndDayBetween(User user, Date from, Date to);
    @Query("SELECT MAX(id) FROM Kmr")
    Long findLastId();
    Kmr findByIdAndUserId(Long id, Long userId);
}
