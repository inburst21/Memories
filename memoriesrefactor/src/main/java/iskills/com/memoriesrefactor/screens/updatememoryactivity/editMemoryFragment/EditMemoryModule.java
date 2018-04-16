package iskills.com.memoriesrefactor.screens.updatememoryactivity.editMemoryFragment;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 4/6/18
 */
@Module
public abstract class EditMemoryModule {

    @Binds
    abstract ContractEditMemory.View editMemoryView(ViewEditMemory viewEditMemory);

    @Binds
    abstract ContractEditMemory.Presenter presenterEditMemory(PresenterEditMemory presenterEditMemory);
}
