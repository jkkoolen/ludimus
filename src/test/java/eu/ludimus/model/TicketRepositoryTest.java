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

import java.security.MessageDigest;

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
        assertEquals(user.getName(),persist.getName());
    }

    @Test
    public void findByAuth() {
        final User persist = this.entityManager.persist(createUser());
        User user = userService.findByAuth(new Auth(EMAIL, PASSWORD));
        assertEquals(user.getName(),persist.getName());
        assertNull(userService.findByAuth(null));
    }

    private User createUser() {
        final User user = new User();
        user.setName(EMAIL);
        user.setPassword(toHex(md5(PASSWORD)));
        return user;
    }

    private byte[] md5(final String password) {
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            return md5.digest();
        } catch(Exception e) {
            e.printStackTrace();
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