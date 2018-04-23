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
    abstract AddMemoryView providesViewAddMemory(AddMemoryFragment addMemoryView);

    @Binds
    abstract AddMemoryPresenter providesPresenterAddMemory(AddMemoryPresenterImpl addMemoryPresenter);
}
