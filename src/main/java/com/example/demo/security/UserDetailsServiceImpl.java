/*
 * Rokomari Culture App
 */

package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User activeUser = userService.getUserByEmail(email);
        if (activeUser == null) {
            throw new RuntimeException("User Not Found");
        }

        Collection<GrantedAuthority> authorities = getGrantedAuthorities(activeUser.getRoles());
        return new org.springframework.security.core.userdetails.User(activeUser.getEmail(), activeUser.getPassword(), authorities);
    }

    protected List<GrantedAuthority> getGrantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole().toString()));
        }
        return authorities;
    }
}
