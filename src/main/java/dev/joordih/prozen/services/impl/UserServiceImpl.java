package dev.joordih.prozen.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dev.joordih.prozen.managers.models.impl.user.User;
import dev.joordih.prozen.managers.models.impl.user.UserRepository;
import dev.joordih.prozen.services.UserService;

import java.time.LocalDateTime;
import java.util.List;

/*
 *
 *  * Copyright © 2025 Jordi Xavier
 *  *
 *  * Class: UserServiceImpl
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:34:22
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

@Singleton
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.find(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User create(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setActive(true);
        return userRepository.create(user);
    }

    @Override
    public User update(String id, User user) {
        user.setId(id);
        return userRepository.update(id, user);
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }
}
