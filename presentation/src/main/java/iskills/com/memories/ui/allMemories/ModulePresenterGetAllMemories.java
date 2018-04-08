package iskills.com.memories.ui.allMemories;

import dagger.Binds;
import dagger.Module;
import iskills.com.memories.di.scopes.ScopePerScreen;

/**
 * lennyhicks
 * 4/1/18
 */

@Module
public abstract class ModulePresenterGetAllMemories {

    @Binds
    @ScopePerScreen
    abstract ContractGetAllMemories.Presenter providesPresenterAddMemory(PresenterGetAllMemories presenterGetAllMemories);

}
