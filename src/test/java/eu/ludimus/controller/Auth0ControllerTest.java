package eu.ludimus.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "eu.ludimus")
@SpringBootTest
public class Auth0ControllerTest {
    @Autowired
    private Auth0Controller auth0Controller;

    @Test
    public void login() throws Exception {
        assertNotNull(auth0Controller);
    }

    @Test
    public void changeLogin() throws Exception {
    }

}