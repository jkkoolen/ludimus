package eu.ludimus.service;

import eu.ludimus.model.Kmr;
import eu.ludimus.model.User;
import eu.ludimus.redis.KmrRedis;
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
    private KmrRedis kmrRedis;

    @Transactional(readOnly = true)
    public List<Kmr> getAllKmr(final Long userId, final Date from, final Date to) {
        final User user = User.builder().build();
        user.setId(userId);
        return kmrRedis.findByUserAndDayBetween(user, from, to);
    }

    @Transactional(readOnly = true)
    public Kmr getLastKmr(final Long userId) {
        final User user = User.builder().build();
        user.setId(userId);
        return kmrRedis.findLastKmrByUser(user);
    }

    @Transactional
    public Kmr addKmr(final Kmr kmr) {
        return kmrRedis.save(kmr);
    }

    @Transactional(readOnly = true)
    public Kmr findById(Long id) {
        return kmrRedis.findById("kmr:" + id);
    }
}
