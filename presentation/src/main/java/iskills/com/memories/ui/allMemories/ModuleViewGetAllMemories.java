package iskills.com.memories.ui.allMemories;

import dagger.Binds;
import dagger.Module;
import iskills.com.memories.di.scopes.ScopePerScreen;

/**
 * lennyhicks
 * 4/1/18
 */
@Module
public abstract class ModuleViewGetAllMemories {

    @Binds
    @ScopePerScreen
    abstract ContractGetAllMemories.View providesViewAddMemory(ViewGetAllMemories viewAddMemory);

}
