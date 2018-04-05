package iskills.com.memories.di;

/**
 * lennyhicks
 * 3/30/18
 */

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import iskills.com.memories.ApplicationMemories;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ModuleApp.class,
        ModuleAndroid.class})
public interface ComponentApp extends AndroidInjector<ApplicationMemories> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);
        ComponentApp build();
    }
}

