package com.example.danocoffee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.danocoffee.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.example.danocoffee.data.Manager> dbuser = managerRepository.findById(username);
        if(dbuser.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username");
        }

        System.out.println(dbuser.get().getMnId());

        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("QUERY"));
        if(dbuser.get().getMnRole().equals("admin"))
            auths.add(new SimpleGrantedAuthority("WRITE"));
        UserDetails ud = User
                .withUsername(dbuser.get().getMnId())
                .password(dbuser.get().getMnPassword())
                .authorities(auths)
                .roles(dbuser.get().getMnRole())
                .build();
        return ud;
    }

}
