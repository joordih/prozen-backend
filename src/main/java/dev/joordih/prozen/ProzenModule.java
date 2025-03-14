package dev.joordih.prozen;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.micronaut.context.ApplicationContext;

public class ProzenModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    ApplicationContext provideApplicationContext() {
        return ApplicationContext.run();
    }
}
