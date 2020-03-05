package com.example.service;

import com.example.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final CustomerDao userHibernateDAO;

    @Autowired
    CustomerUserDetailsService(CustomerDao userHibernateDAO) {
        this.userHibernateDAO = userHibernateDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = (UserDetails) userHibernateDAO.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("USER not found");
        }
        return user;
    }
}
