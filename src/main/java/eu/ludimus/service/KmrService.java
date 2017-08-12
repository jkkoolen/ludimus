package eu.ludimus.service;

import eu.ludimus.model.Kmr;
import eu.ludimus.model.KmrRepository;
import eu.ludimus.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class KmrService {
    private final Logger logger = LoggerFactory.getLogger(KmrService.class);
    @Autowired
    private KmrRepository kmrRepository;

    @Transactional(readOnly = true)
    public List<Kmr> getAllKmr(final Long userId, final Date from, final Date to) {
        final User user = new User();
        user.setId(userId);
        return kmrRepository.findByUserAndDayBetween(user, from, to);
    }

    @Transactional(readOnly = true)
    public Kmr getLastKmr(final Long userId) {
        final Long maxId = kmrRepository.findLastId();
        return kmrRepository.findByIdAndUserId(maxId, userId);
    }

    @Transactional
    public Kmr addKmr(final Kmr kmr) {
        return kmrRepository.save(kmr);
    }

    @Transactional(readOnly = true)
    public Kmr findById(Long id) {
        return kmrRepository.findById(id);
    }

}
