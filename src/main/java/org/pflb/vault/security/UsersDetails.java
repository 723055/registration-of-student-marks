package org.pflb.vault.security;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UsersDetails implements org.springframework.security.core.userdetails.UserDetails {

    private String userName;
    private String password;

    public UsersDetails(String userName, String password){
        this.password = password;
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Lists.newArrayList(new SimpleGrantedAuthority("ROLE_COMMON_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
