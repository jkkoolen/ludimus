package eu.ludimus.controller;

import eu.ludimus.model.Auth;
import eu.ludimus.model.Token;
import eu.ludimus.model.User;
import eu.ludimus.service.Auth0Service;
import eu.ludimus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class Auth0Controller {
    @Autowired
    private UserService userService;
    @Autowired
    private Auth0Service auth0Service;

    @CrossOrigin
    @RequestMapping(value = "/ludimus/login", method = RequestMethod.POST)
    @ResponseBody
    public Token login(final @RequestBody Auth auth) throws UnsupportedEncodingException {
        final User user = userService.findByAuth(auth);
        if(user == null) {
            return new Token(null);
        }
        return auth0Service.createToken(user);
    }
}
