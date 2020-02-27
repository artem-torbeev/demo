package com.example.service;

import com.example.dao.CustomerDao;
import com.example.model.Role;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final CustomerDao userHibernateDAO;

    @Autowired
    CustomerUserDetailsService(CustomerDao userHibernateDAO) {
        this.userHibernateDAO = userHibernateDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userHibernateDAO.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("USER not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRole()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorities);
    }
}
