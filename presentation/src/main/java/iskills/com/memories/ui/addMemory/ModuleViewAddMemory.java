package iskills.com.memories.ui.addMemory;

import dagger.Binds;
import dagger.Module;
import iskills.com.memories.di.scopes.ScopePerScreen;

/**
 * lennyhicks
 * 3/30/18
 */
@Module
public abstract class ModuleViewAddMemory {

    @Binds
    @ScopePerScreen
    abstract ContractAddMemory.View providesViewAddMemory(ViewAddMemory viewAddMemory);
}
