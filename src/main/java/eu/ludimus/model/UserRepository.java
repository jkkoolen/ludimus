package eu.ludimus.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserRepository extends CrudRepository<User, Long>
{
  User findById(final Long id);
  User findByEmail(final String email);
  User findByEmailAndPassword(final String email, final String password);
}