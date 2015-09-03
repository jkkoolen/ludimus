package eu.ludimus.domain.repository;

import eu.ludimus.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>
{
	User findById(Long id);
	User findByName(String name);
	User findByNameAndPassword(String name, String password);
}