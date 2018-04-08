package iskills.com.memories.di.providers.utilsAndroid;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.MainActivity;
import iskills.com.memories.di.scopes.ScopeAndroid;

/**
 * lennyhicks
 * 4/5/18
 */
@Module
public class ModuleUtilsAndroid {

    @ScopeAndroid
    @Provides
    UtilsAndroid provideUtilsAndroid(MainActivity mainActivity){
        return new UtilsAndroid(mainActivity);
    }
}
