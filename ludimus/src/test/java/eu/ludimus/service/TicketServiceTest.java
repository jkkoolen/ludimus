package eu.ludimus.service;

import eu.ludimus.domain.entity.User;
import eu.ludimus.service.config.LudimusServiceConfig;
import eu.ludimus.service.dto.TicketDto;
import eu.ludimus.service.dto.UserDto;
import eu.ludimus.service.dto.mapper.UserDtoMapper;
import eu.ludimus.service.ticket.TicketService;
import eu.ludimus.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@ContextConfiguration(classes = {LudimusServiceConfig.class}, loader = AnnotationConfigContextLoader.class)
public class TicketServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDtoMapper userDtoMapper;


    @Test
    public void patchExisting() throws IOException {
        for(int i : new int[]{2,3,7}) {
            final BufferedImage image = ImageIO.read(getClass().getResourceAsStream("img" + i + ".jpg"));
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", bao);
            final TicketDto ticketDto = ticketService.findById((long) i);
            if(ticketDto != null) {
                ticketDto.ticketImage_$eq(bao.toByteArray());
                ticketService.save(ticketDto);
            }
        }
    }

    public void shouldInsertTicketAndFindById() {
        assertThat(ticketService, notNullValue());

        TicketDto ticketDto = ticketService.save(createTicketDto());
        final TicketDto byId = ticketService.findById(ticketDto.id());
        assertThat(byId.id(), is(ticketDto.id()));
    }

    private TicketDto createTicketDto() {
        TicketDto ticketDto = new TicketDto();
        ticketDto.price_$eq(BigDecimal.ONE);
        ticketDto.invoiceNumber_$eq("testnumber");
        ticketDto.user_$eq(createUserDto());

        return ticketDto;
    }

    private UserDto createUserDto() {
        User user = new User();
        user.setActive(true);
        user.setName("testName");
        user.setPassword("tata");
        user.setRole(User.Role.ROLE_USER);
        return userDtoMapper.map(userService.save(user));
    }

}
