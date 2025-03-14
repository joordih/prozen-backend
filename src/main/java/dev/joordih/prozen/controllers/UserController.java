package dev.joordih.prozen.controllers;

import com.google.inject.Inject;
import dev.joordih.prozen.managers.models.impl.user.User;
import dev.joordih.prozen.services.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import java.util.List;

@Controller("/api/users")
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post
    public HttpResponse<User> create(@Body User user) {
        return HttpResponse.created(userService.create(user));
    }

    @Get
    public HttpResponse<List<User>> findAll() {
        return HttpResponse.ok(userService.findAll());
    }

    @Get("/{id}")
    public HttpResponse<User> findById(@PathVariable String id) {
        return HttpResponse.ok(userService.findById(id));
    }

    @Get("/username/{username}")
    public HttpResponse<User> findByUsername(@PathVariable String username) {
        return HttpResponse.ok(userService.findByUsername(username));
    }

    @Get("/email/{email}")
    public HttpResponse<User> findByEmail(@PathVariable String email) {
        return HttpResponse.ok(userService.findByEmail(email));
    }

    @Put("/{id}")
    public HttpResponse<User> update(@PathVariable String id, @Body User user) {
        return HttpResponse.ok(userService.update(id, user));
    }

    @Delete("/{id}")
    public HttpResponse<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return HttpResponse.noContent();
    }
}
