package iskills.com.memories.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.memories.di.providers.camera.ModuleCamera;
import iskills.com.memories.di.scopes.ScopePerScreen;
import iskills.com.memories.ui.addMemory.ModulePresenterAddMemory;
import iskills.com.memories.ui.addMemory.ModuleViewAddMemory;
import iskills.com.memories.ui.addMemory.ViewAddMemory;
import iskills.com.memories.ui.allMemories.ModulePresenterGetAllMemories;
import iskills.com.memories.ui.allMemories.ModuleViewGetAllMemories;
import iskills.com.memories.ui.allMemories.ViewGetAllMemories;

/**
 * lennyhicks
 * 3/30/18
 */
@Module
abstract class ModuleViews {

    @ScopePerScreen
    @ContributesAndroidInjector(modules = {ModuleViewAddMemory.class, ModulePresenterAddMemory.class})
    abstract ViewAddMemory viewAddMemory();

    @ScopePerScreen
    @ContributesAndroidInjector(modules = {ModuleViewGetAllMemories.class, ModulePresenterGetAllMemories.class})
    abstract ViewGetAllMemories viewGetAllMemories();

}
