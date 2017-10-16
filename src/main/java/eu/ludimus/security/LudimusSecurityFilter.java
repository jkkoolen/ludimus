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
    @Autowired
    private Auth0Service auth0Service;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info(request.getRemoteAddr());
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;
        if(isStatic(httpRequest.getRequestURI().toLowerCase())) {
            chain.doFilter(request, response);
            return;
        }
        if("/ludimus/login".equals(httpRequest.getRequestURI())
                || "/ludimus/distance".equals(httpRequest.getRequestURI())
                || isPreflight(httpRequest)) {
            chain.doFilter(request, response);
            return;
        }
        if(httpRequest.getRequestURI().matches("/ludimus/tax.*")) {
            httpRequest.getRequestDispatcher("/ludimus/index.html").forward(request, response);
            return;
        }
        if(validToken(httpRequest.getHeader(HttpHeaders.AUTHORIZATION)))
        {
            chain.doFilter(request, response);
            return;
        }

        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("{\"error\" : \"Not authorized\"}");
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    private boolean isStatic(final String uri) {
        return uri.endsWith(".css")
                ||   uri.endsWith(".map")
                ||   uri.endsWith(".bmp")
                ||   uri.endsWith(".tif")
                ||   uri.endsWith(".ttf")
                ||   uri.endsWith(".docx")
                ||   uri.endsWith(".woff")
                ||   uri.endsWith(".woff2")
                ||   uri.endsWith(".js")
                ||   uri.endsWith(".pict")
                ||   uri.endsWith(".tiff")
                ||   uri.endsWith(".eot")
                ||   uri.endsWith(".xlsx")
                ||   uri.endsWith(".jpg")
                ||   uri.endsWith(".csv")
                ||   uri.endsWith(".eps")
                ||   uri.endsWith(".xls")
                ||   uri.endsWith(".jpeg")
                ||   uri.endsWith(".doc")
                ||   uri.endsWith(".ejs")
                ||   uri.endsWith(".otf")
                ||   uri.endsWith(".pptx")
                ||   uri.endsWith(".gif")
                ||   uri.endsWith(".pdf")
                ||   uri.endsWith(".swf")
                ||   uri.endsWith(".svg")
                ||   uri.endsWith(".ps")
                ||   uri.endsWith(".ico")
                ||   uri.endsWith(".pls")
                ||   uri.endsWith(".midi")
                ||   uri.endsWith(".svgz")
                ||   uri.endsWith(".class")
                ||   uri.endsWith(".png")
                ||   uri.endsWith(".ppt")
                ||   uri.endsWith(".mid")
                ||   uri.endsWith(".webp")
                ||   uri.endsWith(".html");
    }

    private boolean isPreflight(final HttpServletRequest request) {
        return "OPTIONS".equals(request.getMethod());
    }

    private boolean validToken(final String header) {
        if(header != null && header.startsWith("Bearer ")) {
            final String token = header.substring("Bearer".length()).trim();
            return auth0Service.isValid(new Token(token));
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
