package iskills.com.presentation.screens.memoryactivity.memorygrid;

import dagger.Binds;
import dagger.Module;

/** lennyhicks 4/1/18 */
@Module
public abstract class MemoryGridModule {

  @Binds
  abstract MemoryGridView providesViewAddMemory(MemoryGridFragment viewAddMemory);

  @Binds
  abstract MemoryGridPresenter providesPresenterAddMemory(
      MemoryGridPresenterImpl memoryGridPresenter);
}
