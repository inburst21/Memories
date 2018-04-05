package iskills.com.memories.ui.addMemory;

import dagger.Binds;
import dagger.Module;
import iskills.com.memories.di.scopes.ScopePerScreen;

/**
 * lennyhicks
 * 3/30/18
 */
@Module
public abstract class ModulePresenterAddMemory {

    @Binds
    @ScopePerScreen
    abstract ContractAddMemory.Presenter providesPresenterAddMemory(PresenterAddMemory presenterAddMemory);

}
