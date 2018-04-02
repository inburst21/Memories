package iskills.com.memories.di.providers.location;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.di.ScopePerScreen;

/**
 * lennyhicks
 * 3/31/18
 */
@Module
public class ModuleLocation {

    @ScopePerScreen
    @Provides
    public ProviderLocation locationProvider(Context context) {
        return new ProviderLocation(context);
    }
}
