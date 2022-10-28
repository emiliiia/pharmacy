package com.emilia.pharmacy.service.sql.key;

import com.emilia.pharmacy.entity.sql.SQLKey;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
  @author emilia
  @project pharmacy_2
  @className KeyDetailsPrincipal
  @version 1.0.0
  @since 18.08.2022
*/
public class KeyDetailsPrincipal implements UserDetails {

    private SQLKey key;

    public KeyDetailsPrincipal(SQLKey key){
        this.key = key;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + key.getRole().getRolename()));
        return roles;
    }

    @Override
    public String getPassword() {
        return new BCryptPasswordEncoder().encode(key.getPassword()).toString();
    }

    @Override
    public String getUsername() {
        return key.getUsername();
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
