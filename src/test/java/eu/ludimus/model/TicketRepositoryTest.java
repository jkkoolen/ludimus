package eu.ludimus.model;

import eu.ludimus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static eu.ludimus.hash.HashUtil.md5;
import static eu.ludimus.hash.HashUtil.toHex;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "eu.ludimus.service")
@DataJpaTest
@TestPropertySource(locations="classpath:test.properties")
public class TicketRepositoryTest {

    public static final String PASSWORD = "secret";
    public static final String EMAIL = "jkkoolen@gmail.com";
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repository;

    @Test
    public void findById() {

        final User persist = this.entityManager.persist(createUser());
        User user = repository.findById(persist.getId());
        assertEquals(user.getEmail(),persist.getEmail());
    }

    @Test
    public void findByAuth() {
        final User persist = this.entityManager.persist(createUser());
        User user = userService.findByAuth(new Auth(EMAIL, PASSWORD));
        assertEquals(user.getEmail(),persist.getEmail());
        assertNull(userService.findByAuth(null));
    }

    private User createUser() {
        final User user = new User();
        user.setEmail(EMAIL);
        user.setPassword(toHex(md5(PASSWORD)));
        return user;
    }
}