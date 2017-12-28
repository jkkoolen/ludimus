package eu.ludimus.service;

import eu.ludimus.model.Auth;
import eu.ludimus.model.User;
import eu.ludimus.redis.UserRedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static eu.ludimus.hash.HashUtil.md5;
import static eu.ludimus.hash.HashUtil.toHex;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRedis userRedis;

    @Transactional(readOnly = true)
    public User findByAuth(final Auth auth) {
        if(auth == null) {
            return null;
        }
        return userRedis.findByEmailAndPassword(auth.getEmail(), toHex(md5(auth.getPassword())));
    }

    @Transactional
    public User save(final User user) {
        user.setPassword(toHex(md5(user.getPassword())));
        return userRedis.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRedis.findById("user:" + id);
    }
}
