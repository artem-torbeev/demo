package com.example.dao;

import com.example.model.Role;
import com.example.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserHibernateDAO implements CustomerDao<User> {

    @PersistenceContext
    private EntityManager entityManager;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<User> selectAllUsers() {
        return entityManager.createQuery("from User u", User.class).getResultList();
    }

    @Override
    public void updateUser(Long id, String name, String email) {
        User user = entityManager.find(User.class, id);
        user.setUsername(name);
        user.setEmail(email);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        String hql = "from User u where u.username = :username";
        TypedQuery<User> query = entityManager.createQuery(hql, User.class);
        query.setParameter("username", username);
        List<User> userList = query.getResultList();
        return userList.isEmpty() ? null : userList.get(0);
    }

   @Override
    public void creatUser(User user) {
        String hql = "from Role r where r.id = 1";
        TypedQuery<Role> query = entityManager.createQuery(hql, Role.class);
        List<Role> listRoles = query.getResultList();
        Role role = listRoles.get(0);
        user.getRole().add(role);
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
    }

}