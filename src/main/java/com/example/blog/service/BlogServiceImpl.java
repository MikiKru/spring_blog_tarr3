package com.example.blog.service;

import com.example.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Override
    public boolean addUser(User user) {
        return false;
    }
    @Override
    public boolean deleteUser(long userId) {
        return false;
    }
    @Override
    public boolean updatePassword(long userId, String newPassword) {
        return false;
    }
    @Override
    public List<User> getAllUsersOrderByregistrationDateDesc() {
        return null;
    }
    @Override
    public Optional<User> getUserById(long userId) {
        return Optional.empty();
    }
}
