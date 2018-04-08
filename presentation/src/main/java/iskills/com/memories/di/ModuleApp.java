package iskills.com.memories.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.di.providers.schedulers.ModuleSchedulers;

/**
 * lennyhicks
 * 3/30/18
 */

@Module(includes = {
        ModuleSchedulers.class})
class ModuleApp {

    @Singleton
    @Provides
    Context context(Application application){
        return application.getApplicationContext();
    }


}
