package eu.ludimus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@Import({LudimusWebConfig.class})
public class LudimusSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private Md5PasswordEncoder md5PasswordEncoder;

    @Bean
    public Md5PasswordEncoder md5PasswordEncoder() {
        return new Md5PasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(md5PasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(("/user/**")).hasAnyRole("ADMIN", "USER")
                .antMatchers(("/admin/**")).hasRole("ADMIN")
                .antMatchers(("/**")).permitAll()
                .anyRequest().authenticated()
                .and().formLogin().successHandler(successHandler()).failureUrl("/error").usernameParameter("username").passwordParameter("password").permitAll()
                .and().logout().logoutUrl("/logout").permitAll()
                .and().exceptionHandling().accessDeniedPage("/accessDenied")
                .and().csrf().disable();
    }

    @Bean
    SavedRequestAwareAuthenticationSuccessHandler successHandler() {
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
                super.onAuthenticationSuccess(request, response, authentication);

            }
        };
    }


}
