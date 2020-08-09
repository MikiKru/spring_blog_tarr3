package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.model.Post;
import com.example.blog.model.User;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    // dodawanie użytkownika
    boolean addUser(User user);
    // usuwanie użytkowanika
    boolean deleteUser(long userId);
    // zmiana hasła użytkownika
    boolean updatePassword(long userId, String newPassword);
    // pobranie wszystkich użytkowników
    List<User> getAllUsersOrderByregistrationDateDesc();
    // pobranie użytkownika po id
    Optional<User> getUserById(long userId);

    Post addPostByUser(long userId, String title, String content, Category category);
}
