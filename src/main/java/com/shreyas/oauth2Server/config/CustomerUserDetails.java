package com.shreyas.oauth2Server.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shreyas.oauth2Server.domain.Role;
import com.shreyas.oauth2Server.domain.User;

public class CustomerUserDetails implements UserDetails {

  private String userName;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;
  
  
  public CustomerUserDetails(User user) {
    this.userName = user.getUserName();
    this.password = user.getPassword();
    this.authorities = translate(user.getRoles());
  }
  
  private Collection<? extends GrantedAuthority> translate(List<Role> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (Role role : roles) {
      String name = role.getName().toUpperCase();
      // Make sure that all roles start with "ROLE_"
      if (!name.startsWith("ROLE_"))
        name = "ROLE_" + name;
      authorities.add(new SimpleGrantedAuthority(name));
    }
    return authorities;
  }
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
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
