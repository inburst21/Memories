package iskills.com.memoriesrefactor.screens.memoryactivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.memoriesrefactor.screens.memoryactivity.addmemory.AddMemoryFragment;
import iskills.com.memoriesrefactor.screens.memoryactivity.addmemory.AddMemoryModule;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid.MemoryGridModule;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid.ViewMemoryGrid;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorymap.MemoryMapFragment;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorymap.MemoryMapModule;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorypreviewdialog.MemoryPreviewDialog;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorypreviewdialog.MemoryPreviewModule;

/** lennyhicks 4/15/18 */
@Module
public abstract class MainActivityFragments {
  @ContributesAndroidInjector(modules = MemoryGridModule.class)
  abstract ViewMemoryGrid viewGetAllMemories();

  @ContributesAndroidInjector(modules = AddMemoryModule.class)
  abstract AddMemoryFragment viewAddMemory();

  @ContributesAndroidInjector(modules = MemoryMapModule.class)
  abstract MemoryMapFragment viewMap();

  @ContributesAndroidInjector(modules = MemoryPreviewModule.class)
  abstract MemoryPreviewDialog memoryPreviewDialog();
}
