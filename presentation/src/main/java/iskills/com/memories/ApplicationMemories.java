package iskills.com.memories;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import iskills.com.memories.di.ComponentApp;
import iskills.com.memories.di.DaggerComponentApp;

/**
 * lennyhicks
 * 3/30/18
 */

public class ApplicationMemories extends DaggerApplication {
    ComponentApp componentApp;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        componentApp = DaggerComponentApp.builder().application(this).build();
        return componentApp;
    }

}
