package eu.ludimus.service;

import eu.ludimus.model.Auth;
import eu.ludimus.model.User;
import eu.ludimus.model.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;

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
        return userRepository.findByNameAndPassword(auth.getName(), toHex(md5(auth.getPassword())));
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id);
    }


    private byte[] md5(final String password) {
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            return md5.digest();
        } catch(Exception e) {
            logger.error("Error digesting password ", e);
            return new byte[0];
        }
    }

    private String toHex(final byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
