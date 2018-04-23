package iskills.com.memoriesrefactor.di.activity.utils.adapters;

import dagger.Module;
import dagger.Provides;
import iskills.com.memoriesrefactor.di.services.navigator.Navigator;
import iskills.com.memoriesrefactor.screens.adapters.AdapterMemoryGrid;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid.MemoryGridAdapterPresenter;

/**
 * lennyhicks
 * 4/5/18
 */
@Module
public class ModuleAdapters {

    @Provides
    MemoryGridAdapterPresenter presenterMemoryGrid(Navigator navigator){
        return new MemoryGridAdapterPresenter(navigator);
    }

    @Provides
    AdapterMemoryGrid adapterMemoryGrid(MemoryGridAdapterPresenter presenterMemoryGrid){
        return new AdapterMemoryGrid(presenterMemoryGrid);
    }
}
