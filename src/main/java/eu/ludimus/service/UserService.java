package eu.ludimus.service;

import eu.ludimus.model.Auth;
import eu.ludimus.model.User;
import eu.ludimus.redis.UserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static eu.ludimus.hash.HashUtil.md5;
import static eu.ludimus.hash.HashUtil.toHex;

@Service
public class UserService {
    @Autowired
    private UserRedis userRedis;

    public User findByAuth(final Auth auth) {
        if(auth == null) {
            return null;
        }
        return userRedis.findByEmailAndPassword(auth.getEmail(), toHex(md5(auth.getPassword())));
    }

    public User save(final User user) {
        user.setPassword(toHex(md5(user.getPassword())));
        return userRedis.save(user);
    }

    public User findById(Long id) {
        return userRedis.findById("user:" + id);
    }
}
