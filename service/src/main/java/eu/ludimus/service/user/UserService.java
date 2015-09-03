package eu.ludimus.service.user;

import eu.ludimus.domain.entity.*;

public interface UserService {
    User findById(Long id);
    User save(User user);
    void delete(User user);
    User findByNameAndPassword(String userName, String md5Password);
}
