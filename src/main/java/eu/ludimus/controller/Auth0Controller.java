package eu.ludimus.controller;

import eu.ludimus.model.Auth;
import eu.ludimus.model.ErrorInfo;
import eu.ludimus.model.Token;
import eu.ludimus.model.User;
import eu.ludimus.security.NotAuthorizedException;
import eu.ludimus.service.Auth0Service;
import eu.ludimus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
            throw new NotAuthorizedException("User is not authorized");
        }
        return auth0Service.createToken(user);
    }

    @ExceptionHandler(NotAuthorizedException.class)
    @ResponseStatus(value=HttpStatus.UNAUTHORIZED)
    public ErrorInfo notAuthorized() {
        return new ErrorInfo("NOT_AUTORIZED", "user not authorized");

    }


}
