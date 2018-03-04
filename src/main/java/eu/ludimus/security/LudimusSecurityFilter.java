package eu.ludimus.security;

import eu.ludimus.model.Token;
import eu.ludimus.service.Auth0Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class LudimusSecurityFilter implements Filter {

    public static final String USER_KEY = "user";
    @Autowired
    private Auth0Service auth0Service;

    @Autowired
    private LudimusProperties ludimusProperties;

    @Autowired
    private UserRequestUtil userRequestUtil;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;
        final String requestURI = httpRequest.getRequestURI();

            if(ludimusProperties.isStatic(requestURI)) {
            chain.doFilter(request, response);
            return;
        }

        if(ludimusProperties.isPublic(requestURI)
                || isPreflight(httpRequest)) {
            chain.doFilter(request, response);
            return;
        }

        if(ludimusProperties.shouldForward(requestURI)) {
            httpRequest.getRequestDispatcher(ludimusProperties.getForwardUrl(requestURI)).forward(request, response);
            return;
        }

        if(validToken(httpRequest))
        {
            chain.doFilter(request, response);
            return;
        }

        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("{\"error\" : \"Not authorized\"}");
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    private boolean isPreflight(final HttpServletRequest request) {
        return "OPTIONS".equals(request.getMethod());
    }

    private boolean validToken(HttpServletRequest request) {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(header != null && header.startsWith("Bearer ")) {
            final String bearer = header.substring("Bearer".length()).trim();
            Token token = new Token(bearer);
            boolean valid = auth0Service.isValid(token);
            if(valid) {
                userRequestUtil.setUser(request, auth0Service.userForToken(token));
            }
            return valid;
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
