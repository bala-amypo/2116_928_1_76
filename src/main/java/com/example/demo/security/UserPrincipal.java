package com.example.demo.security;

import com.example.demo.model.PersonProfile;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private final PersonProfile user;

    public UserPrincipal(PersonProfile user) {
        this.user = user;
    }

    // ✅ TESTS EXPECT STRING, NOT OBJECT
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public Collection<?> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
