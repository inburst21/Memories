package iskills.com.memoriesrefactor.screens.memoryactivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.memoriesrefactor.screens.memoryactivity.addmemory.AddMemoryModule;
import iskills.com.memoriesrefactor.screens.memoryactivity.addmemory.AddMemoryView;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid.MemoryGridModule;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid.ViewMemoryGrid;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorymap.ViewMapModule;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorymap.ViewMap;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorypreviewdialog.MemoryPreviewDialog;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorypreviewdialog.MemoryPreviewModule;

/**
 * lennyhicks
 * 4/15/18
 */
@Module
public abstract class MainActivityFragments {
    @ContributesAndroidInjector(modules = MemoryGridModule.class)
    abstract ViewMemoryGrid viewGetAllMemories();

    @ContributesAndroidInjector(modules = AddMemoryModule.class)
    abstract AddMemoryView viewAddMemory();

    @ContributesAndroidInjector(modules = ViewMapModule.class)
    abstract ViewMap viewMap();

    @ContributesAndroidInjector(modules = MemoryPreviewModule.class)
    abstract MemoryPreviewDialog memoryPreviewDialog();

}
