package dev.joordih.prozen.services;

import dev.joordih.prozen.managers.models.impl.user.User;

import java.util.List;

/*
 *
 *  * Copyright © 2025 Jordi Xavier
 *  *
 *  * Class: UserService
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:34:22
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

public interface UserService {
    List<User> findAll();
    User findById(String id);
    User findByUsername(String username);
    User findByEmail(String email);
    User create(User user);
    User update(String id, User user);
    void delete(String id);
}
