package iskills.com.presentation.di.activity.utils.location;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 3/31/18
 */
@Module
public abstract class ModuleLocation {

    @Binds
    abstract PresenterLocation presenterLocation(ProviderLocation providerLocation);

}
