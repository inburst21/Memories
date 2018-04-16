package iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 4/1/18
 */

@Module
public abstract class MemoryGridModule {

    @Binds
    abstract ContractGetAllMemories.View providesViewAddMemory(ViewMemoryGrid viewAddMemory);

    @Binds
    abstract ContractGetAllMemories.Presenter providesPresenterAddMemory(MemoryGridMainPresenter presenterGetAllMemories);

}
