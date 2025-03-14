package dev.joordih.prozen;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Bean;
import dev.joordih.prozen.managers.database.MongoConfig;
import jakarta.inject.Singleton;

/*
 *
 *  * Copyright 2025 Jordi Xavier
 *  *
 *  * Class: ProzenModule
 *  * Project: prozen-backend
 *  * Module: prozen-backend
 *  *
 *  * Last modified: 2025-03-14 14:25:01
 *  *
 *  * All rights reserved. This source code is the property of Jordi Xavier
 *  * and may not be copied, modified, or distributed without explicit permission.
 *
 */

@Factory
public class ProzenModule {
    @Bean
    @Singleton
    MongoConfig mongoConfig() {
        return MongoConfig.builder()
            .uri("mongodb://localhost:27017")
            .database("prozen")
            .build();
    }
}
