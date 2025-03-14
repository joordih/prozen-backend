package dev.joordih.prozen.managers.models.impl.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mongodb.client.model.Filters;
import dev.joordih.prozen.managers.database.MongoConnector;
import dev.joordih.prozen.managers.repository.MongoObjectRepository;

import java.util.ArrayList;
import java.util.List;

/*
 *
 *  * Copyright © 2025 Jordi Xavier
 *  *
 *  * Class: UserRepository
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
public class UserRepository extends MongoObjectRepository<User> {

    @Inject
    public UserRepository(MongoConnector mongoConnector) {
        super(mongoConnector.getCollection("users", User.class));
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        getCollection().find().forEach(users::add);
        return users;
    }

    public User findByUsername(String username) {
        return getCollection().find(Filters.eq("username", username)).first();
    }

    public User findByEmail(String email) {
        return getCollection().find(Filters.eq("email", email)).first();
    }

    public User create(User user) {
        save(user);
        return user;
    }

    public User update(String id, User user) {
        save(user);
        return user;
    }

    public void delete(String id) {
        remove(id);
    }
}
