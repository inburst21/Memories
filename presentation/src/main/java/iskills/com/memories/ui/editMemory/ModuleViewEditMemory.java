package iskills.com.memories.ui.editMemory;

import dagger.Binds;
import dagger.Module;
import iskills.com.memories.di.scopes.ScopePerScreen;

/**
 * lennyhicks
 * 4/6/18
 */
@Module
public abstract class ModuleViewEditMemory {

    @Binds
    @ScopePerScreen
    abstract ContractEditMemory.View editMemoryView(ViewEditMemory viewEditMemory);

}
