package eu.ludimus.authorization;

import eu.ludimus.model.Token;
import eu.ludimus.service.Auth0Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private final Auth0Service auth0Service;
    private final UserRequestUtil userRequestUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (header != null && header.startsWith("Bearer ")) {
                final String bearer = header.substring("Bearer".length()).trim();
                Token token = new Token(bearer);
                if(! auth0Service.isValid(token)) {
                    log.warn("User not known by us!");
                    setUnAuthorizedResponse(response);
                }
                userRequestUtil.setUser(request, auth0Service.userForToken(token));
                return true;
            }
        } catch(Exception e) {
            log.warn("Invalid token!, someone is trying nasty things ");
            setUnAuthorizedResponse(response);
        }
        return false;
    }

    private static void setUnAuthorizedResponse(final HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("{\"message\" : \"Not authorized\"}");
        response.getWriter().flush();
        response.getWriter().close();
    }
}
