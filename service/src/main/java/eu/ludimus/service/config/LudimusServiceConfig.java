package eu.ludimus.service.config;

import eu.ludimus.domain.config.LudimusDomainConfig;
import eu.ludimus.service.authentication.LudimusSecurityContext;
import eu.ludimus.service.authentication.UserDetailsServiceImpl;
import eu.ludimus.service.utils.DefaultImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@ComponentScan(basePackages = {"eu.ludimus.service"})
@Import(LudimusDomainConfig.class)
public class LudimusServiceConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public LudimusSecurityContext securityContext() {
        return new LudimusSecurityContext();
    }

    @Bean
    public DefaultImageService imageService() {
        return new DefaultImageService();
    }
}
