package iskills.com.memories.di.providers.date;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.MainActivity;
import iskills.com.memories.di.scopes.ScopeAndroid;

/**
 * lennyhicks
 * 4/3/18
 */
@Module
public class ModuleDate {

    @Provides
    @ScopeAndroid
    PresenterDate presenterDate(MainActivity activity){
        return new UtilsDate(activity);
    }
}
