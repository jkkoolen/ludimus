package eu.ludimus.service.authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class LudimusUserDetails implements UserDetails
{
    private static final long serialVersionUID = 7526472295622776147L;
    private User user;
    private eu.ludimus.domain.entity.User entity;
    protected LudimusUserDetails(User user, eu.ludimus.domain.entity.User entity) {
        this.user = user;
        this.entity = entity;
    }

    public eu.ludimus.domain.entity.User getUser() {
        return entity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return user.getAuthorities();
    }

    @Override
    public String getPassword()
    {
        return user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled()
    {
        return user.isEnabled();
    }
}
