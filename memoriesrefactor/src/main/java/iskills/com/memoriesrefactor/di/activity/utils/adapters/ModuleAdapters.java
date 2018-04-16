package iskills.com.memoriesrefactor.di.activity.utils.adapters;

import dagger.Module;
import dagger.Provides;
import iskills.com.memoriesrefactor.di.activity.utils.date.PresenterDate;
import iskills.com.memoriesrefactor.screens.adapters.AdapterMemoryGrid;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid.MemoryGridSubPresenter;

/**
 * lennyhicks
 * 4/5/18
 */
@Module
public class ModuleAdapters {

    @Provides
    MemoryGridSubPresenter presenterMemoryGrid(PresenterDate date){
        return new MemoryGridSubPresenter(date);
    }

    @Provides
    AdapterMemoryGrid adapterMemoryGrid(MemoryGridSubPresenter presenterMemoryGrid){
        return new AdapterMemoryGrid(presenterMemoryGrid);
    }
}
