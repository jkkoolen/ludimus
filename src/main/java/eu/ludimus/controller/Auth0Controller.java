package eu.ludimus.controller;

import eu.ludimus.controller.exception.InvalidPasswordException;
import eu.ludimus.model.*;
import eu.ludimus.authorization.NotAuthorizedException;
import eu.ludimus.redis.AlreadyExistsException;
import eu.ludimus.service.Auth0Service;
import eu.ludimus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/ludimus")
public class Auth0Controller {
    private final UserService userService;
    private final Auth0Service auth0Service;

    @Autowired
    public Auth0Controller(UserService userService, Auth0Service auth0Service) {
        this.userService = userService;
        this.auth0Service = auth0Service;
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Token login(final @RequestBody Auth auth) throws UnsupportedEncodingException {
        final User user = userService.findByAuth(auth);
        if(user == null) {
            throw new NotAuthorizedException("User is not authorized");
        }
        return auth0Service.createToken(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/secure/changeLogin", method = RequestMethod.POST)
    @ResponseBody
    public Token changeLogin(final @RequestBody ChangeAuth auth) throws UnsupportedEncodingException {
        final User user = userService.findByAuth(auth);
        if(user == null) {
            throw new NotAuthorizedException("User is not authorized to change password");
        }
        if(auth.getNewPassword1() == null || auth.getNewPassword2() == null || !auth.getNewPassword1().equals(auth.getNewPassword2())) {
            throw new InvalidPasswordException("new passwords are empty or not equal");
        }
        user.setPassword(auth.getNewPassword1());
        return auth0Service.createToken(userService.save(user));
    }

    @CrossOrigin
    @RequestMapping(value = "/secure/createUser", method = RequestMethod.POST)
    @ResponseBody
    public Boolean createUser(final @RequestBody Auth auth) {
        final User user = User.builder().email(auth.getEmail()).password(auth.getPassword()).build();
        User savedUser = userService.save(user);
        return savedUser != null;
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ErrorInfo alreadyExists(final AlreadyExistsException e) {
        return new ErrorInfo("ALREADY_EXISTS", e.getMessage());

    }

    @ExceptionHandler(NotAuthorizedException.class)
    @ResponseStatus(value=HttpStatus.UNAUTHORIZED)
    public ErrorInfo notAuthorized(final NotAuthorizedException e) {
        return new ErrorInfo("NOT_AUTORIZED", e.getMessage());

    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ErrorInfo invalid(final InvalidPasswordException e) {
        return new ErrorInfo("BAD_REQUEST", e.getMessage());

    }
}
