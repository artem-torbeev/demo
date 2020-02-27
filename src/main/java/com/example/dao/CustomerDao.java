package com.example.dao;

import com.example.model.User;

import java.util.List;

public interface CustomerDao<T> {

    List<T> selectAllUsers();

    void updateUser(Long id, String name, String email);

    void creatUser(T user);

    void deleteUser(Long id);

    T getUserById(Long id);

    T getUserByUsername(String username);
}
