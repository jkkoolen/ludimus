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
        User user = userRedis.findByEmail(auth.getEmail());
        if(user != null && user.getPassword().equals(toHex(md5(auth.getPassword())))) {
            return user;
        }
        return null;
    }

    public User save(final User user) {
        user.setPassword(toHex(md5(user.getPassword())));
        return userRedis.save(user);
    }

    public User findById(Long id) {
        return userRedis.findById("user:" + id);
    }

    public User findByEmail(final String email) {
        return userRedis.findByEmail(email);
    }
}
