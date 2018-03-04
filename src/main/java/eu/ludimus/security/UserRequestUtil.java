package eu.ludimus.security;

import eu.ludimus.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Component
public class UserRequestUtil {

    private static final String USER = "user";

    public void setUser(final ServletRequest request, final User user) {
        request.setAttribute(USER, user);
    }

    public User getUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (User) request.getAttribute(USER);
    }
}
