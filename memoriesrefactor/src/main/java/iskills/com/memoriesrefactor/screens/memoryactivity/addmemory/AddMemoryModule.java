package iskills.com.memoriesrefactor.screens.memoryactivity.addmemory;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 3/30/18
 */
@Module
public abstract class AddMemoryModule {

    @Binds
    abstract ContractAddMemory.View providesViewAddMemory(AddMemoryView addMemoryView);

    @Binds
    abstract ContractAddMemory.Presenter providesPresenterAddMemory(AddMemoryPresenter addMemoryPresenter);
}
