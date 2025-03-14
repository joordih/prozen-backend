package dev.joordih.prozen.managers;

import com.google.inject.AbstractModule;
import dev.joordih.prozen.managers.models.impl.user.UserRepository;
import dev.joordih.prozen.managers.repository.TaskRepository;
import dev.joordih.prozen.services.TaskService;
import dev.joordih.prozen.services.UserService;
import dev.joordih.prozen.services.impl.TaskServiceImpl;
import dev.joordih.prozen.services.impl.UserServiceImpl;

public class ManagersModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserRepository.class).asEagerSingleton();
        bind(TaskRepository.class).asEagerSingleton();
        bind(TaskService.class).to(TaskServiceImpl.class).asEagerSingleton();
        bind(UserService.class).to(UserServiceImpl.class).asEagerSingleton();
    }
}
