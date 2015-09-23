package eu.ludimus.domain.repository;

import eu.ludimus.domain.entity.Address;
import eu.ludimus.domain.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
    Address findByUser(User user);
}
