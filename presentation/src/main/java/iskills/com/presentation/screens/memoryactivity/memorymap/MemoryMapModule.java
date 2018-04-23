package iskills.com.presentation.screens.memoryactivity.memorymap;

import dagger.Binds;
import dagger.Module;

/** lennyhicks 4/8/18 */
@Module
public abstract class MemoryMapModule {

  @Binds
  abstract MemoryMapView mapView(MemoryMapFragment viewMap);

  @Binds
  abstract MemoryMapPresenter mapPresenter(ViewMapPresenterImpl presenterMap);
}
