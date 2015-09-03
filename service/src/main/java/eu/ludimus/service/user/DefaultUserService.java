package eu.ludimus.service.user;

import eu.ludimus.domain.entity.*;
import eu.ludimus.domain.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public final class DefaultUserService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
	@Override
	public User findByNameAndPassword(String userName, String md5Password) {
		return userRepository.findByNameAndPassword(userName, md5Password);
	}
}
