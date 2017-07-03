package eu.ludimus.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserRepository extends CrudRepository<User, Long>
{
  User findById(Long id);
  User findByName(String name);
  User findByNameAndPassword(String name, String password);
}