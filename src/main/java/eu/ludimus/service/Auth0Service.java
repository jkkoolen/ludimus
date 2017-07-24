package eu.ludimus.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import eu.ludimus.model.Token;
import eu.ludimus.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

@Service
public class Auth0Service {
    private static Logger logger = LoggerFactory.getLogger(Auth0Service.class);
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
            logger.debug("Your token has been expired!");
            return false;
        }

        User user = null;
        try {
            final long id = Long.parseLong(decode.getClaim("id").asString());
            user = userService.findById(id);
            if (user == null) {
                logger.debug("User {} not known!", id);
                return false;
            }
        }catch(NumberFormatException e) {
            logger.debug("JWT contains invalid id");
        }
        return (decode.getClaim("email").asString().equals(user.getEmail()));
    }

    public Long idFromAuthorizationHeader(final String authorization) {
        Long id = -1L;
        if(authorization != null && authorization.startsWith("Bearer ")) {
            final String token = authorization.substring("Bearer".length()).trim();
            final JWT jwt = JWT.decode(token);
            id = Long.parseLong(jwt.getClaim("id").asString());
        }
        return id;
    }
}
