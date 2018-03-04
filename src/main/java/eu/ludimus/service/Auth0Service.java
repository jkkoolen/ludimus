package eu.ludimus.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import eu.ludimus.model.Token;
import eu.ludimus.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

@Service
@Slf4j
public class Auth0Service {
    @Autowired
    private UserService userService;

    public Token createToken(final User user) throws UnsupportedEncodingException {
        Calendar calendar = Calendar.getInstance(); // gets a calendar using the default time zone and locale.
        calendar.add(Calendar.MINUTE, 30);
        return new Token(JWT.create()
                .withClaim("id", String.valueOf(user.getId()))
                .withClaim("email", user.getEmail())
                .withClaim("exp", calendar.getTime())
                .sign(Algorithm.HMAC256(user.getPassword())));
    }

    public boolean isValid(final Token token) {
        final JWT decode = JWT.decode(token.getToken());
        final Date exp = decode.getClaim("exp").asDate();
        if(exp.getTime() < new Date().getTime()) {
            log.debug("Your token has been expired!");
            return false;
        }

        User user = null;
        try {
            final long id = Long.parseLong(decode.getClaim("id").asString());
            user = userService.findById(id);
            if (user == null) {
                log.debug("User {} not known!", id);
                return false;
            }
        }catch(NumberFormatException e) {
            log.debug("JWT contains invalid id");
        }
        return decode.getClaim("email").asString().equals(user.getEmail());
    }

    public User userForToken(final Token token) {
        final JWT decode = JWT.decode(token.getToken());
        final Date exp = decode.getClaim("exp").asDate();
        if(exp.getTime() < new Date().getTime()) {
            log.debug("Your token has been expired!");
            return null;
        }
        try {
            final long id = Long.parseLong(decode.getClaim("id").asString());
            return userService.findById(id);
        }catch(NumberFormatException e) {
            log.debug("JWT contains invalid id");
        }
        return null;
    }

//    public Long idFromAuthorizationHeader(final String authorization) {
//        Long id = -1L;
//        if(authorization != null && authorization.startsWith("Bearer ")) {
//            final String token = authorization.substring("Bearer".length()).trim();
//            final JWT jwt = JWT.decode(token);
//            id = Long.parseLong(jwt.getClaim("id").asString());
//        }
//        return id;
//    }
}
