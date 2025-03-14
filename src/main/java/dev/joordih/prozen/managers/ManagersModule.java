package dev.joordih.prozen.managers;

import com.google.inject.AbstractModule;
import dev.joordih.prozen.managers.models.impl.user.UserRepository;
import dev.joordih.prozen.managers.models.impl.task.TaskRepository;
import dev.joordih.prozen.services.TaskService;
import dev.joordih.prozen.services.UserService;
import dev.joordih.prozen.services.impl.TaskServiceImpl;
import dev.joordih.prozen.services.impl.UserServiceImpl;

/*
 *
 *  * Copyright © 2025 Jordi Xavier
 *  *
 *  * Class: ManagersModule
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:22:25
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

public class ManagersModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserRepository.class).asEagerSingleton();
        bind(TaskRepository.class).asEagerSingleton();
        bind(TaskService.class).to(TaskServiceImpl.class).asEagerSingleton();
        bind(UserService.class).to(UserServiceImpl.class).asEagerSingleton();
    }
}
