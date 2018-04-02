package iskills.com.memories.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.di.providers.location.ModuleLocation;
import iskills.com.memories.utils.UtilsAndroid;

/**
 * lennyhicks
 * 3/30/18
 */

@Module(includes = {ModuleAppDb.class, ModuleLocation.class})
class ModuleApp {

    @Singleton
    @Provides
    Context context(Application application){
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    UtilsAndroid provideUtilsAndroid(Context context){
        return new UtilsAndroid(context);
    }
}
