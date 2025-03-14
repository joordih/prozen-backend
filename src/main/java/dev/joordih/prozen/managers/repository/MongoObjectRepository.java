package dev.joordih.prozen.managers.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import dev.joordih.prozen.managers.models.Model;
import lombok.Getter;

@Getter
public class MongoObjectRepository<T extends Model> implements ObjectRepository<T> {

    protected final MongoCollection<T> collection;

    public MongoObjectRepository(MongoCollection<T> collection) {
        this.collection = collection;
    }

    @Override
    public T find(String id) {
        return collection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public void remove(String id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public void save(T model) {
        collection.replaceOne(
            Filters.eq("_id", model.getId()),
            model,
            new ReplaceOptions().upsert(true)
        );
    }

    protected MongoCollection<T> getCollection() {
        return collection;
    }
}
