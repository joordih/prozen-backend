package dev.joordih.prozen.managers.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;

/*
 *
 *  * Copyright © 2025 Jordi Xavier
 *  *
 *  * Class: MongoConnector
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:29:04
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

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
    System.out.println("aaa");
    return MongoClientSettings.builder()
        .applyConnectionString(new ConnectionString(uri))
        .codecRegistry(CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())))
        .uuidRepresentation(UuidRepresentation.STANDARD)
        .build();
  }
}
