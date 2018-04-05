package iskills.com.memories.di.providers.location;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.MainActivity;
import iskills.com.memories.di.scopes.ScopeAndroid;

/**
 * lennyhicks
 * 3/31/18
 */
@Module
public class ModuleLocation {

    @ScopeAndroid
    @Provides
    PresenterLocation presenterLocation(MainActivity activity){
        return new ProviderLocation(activity);
    }
}
