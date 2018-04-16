package iskills.com.memoriesrefactor.screens.memoryactivity.memorymap;

import dagger.Binds;
import dagger.Module;

/**
 * lennyhicks
 * 4/8/18
 */

@Module
public abstract class ViewMapModule {

    @Binds
    abstract ContractMemoryMap.View mapView(ViewMap viewMap);


    @Binds
    abstract ContractMemoryMap.Presenter mapPresenter(ViewMapPresenter presenterMap);

}
