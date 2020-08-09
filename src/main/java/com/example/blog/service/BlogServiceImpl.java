package com.example.blog.service;

import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    private UserRepository userRepository;
    @Autowired
    public BlogServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean addUser(User user) {
        return userRepository.save(user) != null;   // INSERT INTO user VALUES (?,?,?,?,?);
    }
    @Override
    public boolean deleteUser(long userId) {
        boolean isDeleted = userRepository.existsById(userId);
        userRepository.deleteById(userId);
        return isDeleted;
    }
    @Override
    public Optional<User> getUserById(long userId) {
        return userRepository.findById(userId);
    }
    @Override
    public boolean updatePassword(long userId, String newPassword) {
        return false;
    }
    @Override
    public List<User> getAllUsersOrderByregistrationDateDesc() {
        return userRepository.findAll();
    }

}
