package eu.ludimus.service;

import eu.ludimus.model.Kmr;
import eu.ludimus.model.User;
import eu.ludimus.redis.KmrRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KmrService {
    @Autowired
    private KmrRedis kmrRedis;

    public List<Kmr> getAllKmr(final Long userId, final Date from, final Date to) {
        final User user = User.builder().build();
        user.setId(userId);
        return kmrRedis.findByUserAndDayBetween(user, from, to);
    }

    public Kmr getLastKmr(final Long userId) {
        final User user = User.builder().build();
        user.setId(userId);
        return kmrRedis.findLastKmrByUser(user);
    }

    public Kmr addKmr(final Kmr kmr) {
        return kmrRedis.save(kmr);
    }

    public Kmr findById(Long id) {
        return kmrRedis.findById("kmr:" + id);
    }
}
