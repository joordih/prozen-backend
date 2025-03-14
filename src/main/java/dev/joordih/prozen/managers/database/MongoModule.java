package dev.joordih.prozen.managers.database;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoModule extends AbstractModule {

    private final MongoConfig config;

    public MongoModule(MongoConfig config) {
        this.config = config;
    }

    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    MongoClient provideMongoClient() {
        return MongoClients.create(config.getUri());
    }

    @Provides
    @Singleton
    MongoDatabase provideMongoDatabase(MongoClient client) {
        return client.getDatabase(config.getDatabase());
    }

    @Provides
    @Singleton
    MongoConnector provideMongoConnector(MongoDatabase database) {
        return new MongoConnector(database);
    }
}
