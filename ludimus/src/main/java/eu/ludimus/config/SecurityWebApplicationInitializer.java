package eu.ludimus.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebApplicationInitializer() {
        super(LudimusSecurityConfig.class);
    }

    @Override
    protected void afterSpringSecurityFilterChain(ServletContext container) {
        super.afterSpringSecurityFilterChain(container);
//        final ServletRegistration.Dynamic servlet = container.addServlet("facesServlet", FacesServlet.class);
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("*.xhtml");


        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
