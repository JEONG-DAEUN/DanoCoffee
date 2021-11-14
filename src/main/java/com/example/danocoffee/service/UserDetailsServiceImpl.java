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
    public UserDetails loadUserByUsername(String mnId) throws UsernameNotFoundException {
        Optional<com.example.danocoffee.data.Manager> dbmanager = managerRepository.findById(mnId);
        if (dbmanager.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username");
        }

        List<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority("QUERY"));
        if (dbmanager.get().getMnRole().equals("admin")) {
            auth.add(new SimpleGrantedAuthority("WRITE"));
        }

        UserDetails ud = User
                .withUsername(dbmanager.get().getMnId())
                .password((dbmanager.get().getMnPassword()))
                .authorities(auth)
                .roles(dbmanager.get().getMnRole())
                .build();
        return ud;
    }

}
