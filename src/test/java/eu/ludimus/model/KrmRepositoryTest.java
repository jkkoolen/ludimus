package eu.ludimus.model;

import eu.ludimus.service.KmrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static eu.ludimus.hash.HashUtil.md5;
import static eu.ludimus.hash.HashUtil.toHex;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "eu.ludimus.service")
@DataJpaTest
@TestPropertySource(locations="classpath:test.properties")
public class KrmRepositoryTest {

    private static Date NOW = new Date();
    private static Date YESTERDAY = new Date(NOW.getTime() - 1000*60*60*24);
    private static Date TOMORROW = new Date(NOW.getTime() + 1000*60*60*24);
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private KmrService kmrService;

    @Test
    public void findById() {
        final User persistedUser = this.entityManager.persist(createUser());

        final Kmr persistedKmr = this.entityManager.persist(createKmr(persistedUser));
        Kmr kmr = kmrService.findById(persistedKmr.getId());
        assertEquals(kmr.getEndTotal(),persistedKmr.getEndTotal());
    }

    @Test
    public void getAllKmr() {
        final User persistedUser = this.entityManager.persist(createUser());
        final Kmr persistedKmr = this.entityManager.persist(createKmr(persistedUser));
        List<Kmr> kmrList = kmrService.getAllKmr(persistedUser.getId(), YESTERDAY, TOMORROW);
        assertEquals(kmrList.size(), 1);
        assertEquals(kmrList.get(0).getEndTotal(),persistedKmr.getEndTotal());
    }

    @Test
    public void  lastKmr() {
        final User persistedUser = this.entityManager.persist(createUser());
        final Kmr persistedKmr = this.entityManager.persist(createKmr(persistedUser));
        final Kmr lastKmr = kmrService.getLastKmr(persistedUser.getId());
        assertNotNull(lastKmr);
    }

    private Kmr createKmr(final User persitedUser) {
        return Kmr.builder()
                .day(NOW)
                .origin("Mattenbiesstraat 137, Amsterdan")
                .destination("Croeselaan 7, Utrecht")
                .isBusiness(true)
                .endTotal(159844)
                .startTotal(159800)
                .user(persitedUser).build();
    }

    private User createUser() {
        return User.builder()
                .email("jkkoolen@gmail.com")
                .password(toHex(md5("secret"))).build();
    }
}