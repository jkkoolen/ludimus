package eu.ludimus.service;

import eu.ludimus.model.Auth;
import eu.ludimus.model.User;
import eu.ludimus.model.UserRepository;
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
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findByAuth(final Auth auth) {
        if(auth == null) {
            return null;
        }
        return userRepository.findByEmailAndPassword(auth.getEmail(), toHex(md5(auth.getPassword())));
    }

    @Transactional
    public User save(final User user) {
        user.setPassword(toHex(md5(user.getPassword())));
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
