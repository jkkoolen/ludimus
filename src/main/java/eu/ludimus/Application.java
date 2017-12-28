package eu.ludimus;

import eu.ludimus.converter.Jpg2TextConverter;
import eu.ludimus.model.KmrRepository;
import eu.ludimus.model.Ticket;
import eu.ludimus.model.TicketRepository;
import eu.ludimus.model.User;
import eu.ludimus.model.UserRepository;
import eu.ludimus.redis.KmrRedis;
import eu.ludimus.redis.TicketRedis;
import eu.ludimus.redis.UserRedis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "eu.ludimus")
@EnableConfigurationProperties
@Slf4j
public class Application  {
  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private KmrRepository kmrRepository;

  @Autowired
  private TicketRedis ticketRedis;
  @Autowired
  private UserRedis userRedis;
  @Autowired
  private KmrRedis kmrRedis;
  @Autowired
  private JedisPool jedisPool;

  @PostConstruct
  public void prepareRedis() {
    try {
      log.info("------------------------------------------------------------");
      final Jedis jedis = jedisPool.getResource();
      jedis.flushAll();
      userRepository.findAll().forEach(user -> userRedis.save(user));
      ticketRepository.findAll().forEach(ticket -> ticketRedis.save(ticket));
      kmrRepository.findAll().forEach(kmr -> kmrRedis.save(kmr));
      System.out.println("keys ----- " + jedis.keys("*:user:1"));
      final User u = User.builder().build();
      u.setId(2L);
      final Calendar instance = Calendar.getInstance();
      instance.add(Calendar.MONTH, -2);
      System.out.println(ticketRedis.findByUserAndTicketDateBetween(u, instance.getTime(), new Date()).size());
      final User u2 = User.builder().build();
      u2.setId(1L);
      final List<Ticket> allByUser = ticketRedis.findAllByUser(u);
      System.out.println(allByUser.get(0).getDescription());
      System.out.println(ticketRedis.findAllByUser(u2).size());

      final User secret = User.builder().email("test@gmail.com").password("secret").active(true).build();
      userRedis.save(secret);
      ticketRedis.andSearchByUser(u, "factuur", "Rabobank").stream().map((t) -> t.getDescription() + ' ' + t.getId()).forEach(System.out::println);

      log.info("------------------------------------------------------------");
      jedis.close();
      System.out.println(Jpg2TextConverter.toText(ticketRedis.findAllByUser(u).get(8).getTicketImage()));
      System.exit(0);
    }catch(Exception e) {
      log.error("model2json error", e);
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
