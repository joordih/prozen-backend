package dev.joordih.prozen;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dev.joordih.prozen.managers.ManagersModule;
import dev.joordih.prozen.managers.database.MongoConfig;
import dev.joordih.prozen.managers.database.MongoModule;
import io.micronaut.runtime.Micronaut;

public class Prozen {
    private final Injector injector;

    public Prozen() {
        MongoConfig mongoConfig = MongoConfig.builder()
            .uri("mongodb://localhost:27017")
            .database("prozen")
            .build();

        injector = Guice.createInjector(
            new ProzenModule(),
            new MongoModule(mongoConfig),
            new ManagersModule()
        );
    }

    public static void main(String[] args) {
        Micronaut.run(Prozen.class, args);
    }

    public Injector getInjector() {
        return injector;
    }
}