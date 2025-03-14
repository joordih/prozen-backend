package dev.joordih.prozen.managers.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;

@Getter
public class MongoConnector {
    private final MongoDatabase database;

    public MongoConnector(MongoDatabase database) {
        this.database = database;
    }

    public <T> MongoCollection<T> getCollection(String collectionName, Class<T> documentClass) {
        return database.getCollection(collectionName, documentClass);
    }

    public static MongoClientSettings createSettings(String uri) {
        return MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(uri))
            .codecRegistry(CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            ))
            .uuidRepresentation(UuidRepresentation.STANDARD)
            .build();
    }
}
