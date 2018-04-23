package iskills.com.presentation.di.application;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import iskills.com.presentation.MemoriesApplication;
import iskills.com.presentation.di.activity.PresentationModule;
import iskills.com.presentation.di.scopes.ApplicationScope;

/**
 * lennyhicks
 * 4/14/18
 */

@ApplicationScope
@Component(modules = {
        ApplicationModule.class,
        DatabaseModule.class,
        AndroidSupportInjectionModule.class,
        PresentationModule.class,})

public interface ApplicationComponent extends AndroidInjector<MemoriesApplication> {

    Application app();

    @Component.Builder
    interface Builder {
        @BindsInstance
        ApplicationComponent.Builder application(Application application);
        ApplicationComponent build();
    }
}
