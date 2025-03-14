package dev.joordih.prozen.managers.models.impl.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mongodb.client.model.Filters;
import dev.joordih.prozen.managers.database.MongoConnector;
import dev.joordih.prozen.managers.repository.MongoObjectRepository;
import java.util.ArrayList;
import java.util.List;

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
