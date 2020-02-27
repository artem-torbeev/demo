package com.example.service;

import com.example.dao.CustomerDao;
import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService implements CustomerService<User> {

    private final CustomerDao userHibernateDAO;

    @Autowired
    public UserService(CustomerDao userHibernateDAO) {
        this.userHibernateDAO = userHibernateDAO;
    }


    @Override
    public List<User> selectAllUsers() {
        return userHibernateDAO.selectAllUsers();
    }

    @Override
    @Transactional
    public void updateUser(Long id, String name, String email) {
        userHibernateDAO.updateUser(id, name, email);
    }

    @Override
    @Transactional
    public void creatUser(User user) {
        userHibernateDAO.creatUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userHibernateDAO.deleteUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return (User) userHibernateDAO.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return (User) userHibernateDAO.getUserByUsername(username);
    }

}

