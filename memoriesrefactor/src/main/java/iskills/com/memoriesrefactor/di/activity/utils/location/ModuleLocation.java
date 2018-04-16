package iskills.com.memoriesrefactor.di.activity.utils.location;

import dagger.Binds;
import dagger.Module;
import iskills.com.memoriesrefactor.di.scopes.ActivityScope;

/**
 * lennyhicks
 * 3/31/18
 */
@Module
public abstract class ModuleLocation {

    @ActivityScope
    @Binds
    abstract PresenterLocation presenterLocation(ProviderLocation providerLocation);

}
