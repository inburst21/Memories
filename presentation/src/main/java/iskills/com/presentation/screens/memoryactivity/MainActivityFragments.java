package iskills.com.presentation.screens.memoryactivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.presentation.screens.memoryactivity.addmemory.AddMemoryFragment;
import iskills.com.presentation.screens.memoryactivity.addmemory.AddMemoryModule;
import iskills.com.presentation.screens.memoryactivity.memorygrid.MemoryGridFragment;
import iskills.com.presentation.screens.memoryactivity.memorygrid.MemoryGridModule;
import iskills.com.presentation.screens.memoryactivity.memorymap.MemoryMapFragment;
import iskills.com.presentation.screens.memoryactivity.memorymap.MemoryMapModule;
import iskills.com.presentation.screens.memoryactivity.memorypreviewdialog.MemoryPreviewDialog;
import iskills.com.presentation.screens.memoryactivity.memorypreviewdialog.MemoryPreviewModule;

/** lennyhicks 4/15/18 */
@Module
public abstract class MainActivityFragments {
  @ContributesAndroidInjector(modules = MemoryGridModule.class)
  abstract MemoryGridFragment viewGetAllMemories();

  @ContributesAndroidInjector(modules = AddMemoryModule.class)
  abstract AddMemoryFragment viewAddMemory();

  @ContributesAndroidInjector(modules = MemoryMapModule.class)
  abstract MemoryMapFragment viewMap();

  @ContributesAndroidInjector(modules = MemoryPreviewModule.class)
  abstract MemoryPreviewDialog memoryPreviewDialog();
}
