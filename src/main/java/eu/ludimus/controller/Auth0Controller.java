package eu.ludimus.controller;

import eu.ludimus.exception.InvalidException;
import eu.ludimus.model.*;
import eu.ludimus.exception.NotAuthorizedException;
import eu.ludimus.service.Auth0Service;
import eu.ludimus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
public class Auth0Controller {
    private final UserService userService;
    private final Auth0Service auth0Service;

    @Autowired
    public Auth0Controller(UserService userService, Auth0Service auth0Service) {

        this.userService = userService;
        this.auth0Service = auth0Service;
    }

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

    @CrossOrigin
    @RequestMapping(value = "/ludimus/changeLogin", method = RequestMethod.POST)
    @ResponseBody
    public Token changeLogin(final @RequestBody ChangeAuth auth) throws UnsupportedEncodingException {
        final User user = userService.findByAuth(auth);
        if(user == null) {
            throw new NotAuthorizedException("User is not authorized to change password");
        }
        if(auth.getNewPassword1() == null || auth.getNewPassword2() == null || !auth.getNewPassword1().equals(auth.getNewPassword2())) {
            throw new InvalidException("new passwords are empty or not equal");
        }
        user.setPassword(auth.getNewPassword1());
        return auth0Service.createToken(userService.save(user));
    }

    @ExceptionHandler(NotAuthorizedException.class)
    @ResponseStatus(value=HttpStatus.UNAUTHORIZED)
    public ErrorInfo notAuthorized(final NotAuthorizedException e) {
        return new ErrorInfo("NOT_AUTORIZED", e.getMessage());

    }

    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ErrorInfo invalid(final InvalidException e) {
        return new ErrorInfo("BAD_REQUEST", e.getMessage());

    }
}
