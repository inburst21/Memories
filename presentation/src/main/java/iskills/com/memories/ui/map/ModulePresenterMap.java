package iskills.com.memories.ui.map;

import dagger.Binds;
import dagger.Module;
import iskills.com.memories.di.scopes.ScopePerScreen;

/**
 * lennyhicks
 * 4/8/18
 */

@Module
public abstract class ModulePresenterMap {

    @Binds
    @ScopePerScreen
    abstract ContractMemoryMap.Presenter mapPresenter(PresenterMap presenterMap);
}
