package iskills.com.memories.ui.addMemory;

import dagger.Binds;
import dagger.Module;
import iskills.com.memories.di.ScopePerScreen;
import iskills.com.memories.di.providers.location.ModuleLocation;

/**
 * lennyhicks
 * 3/30/18
 */
@Module(includes = ModuleLocation.class)
public abstract class ModuleViewAddMemory {

    @Binds
    @ScopePerScreen
    abstract ContractAddMemory.View providesViewAddMemory(ViewAddMemory viewAddMemory);
}
