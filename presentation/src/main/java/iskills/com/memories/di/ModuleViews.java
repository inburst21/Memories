package iskills.com.memories.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.memories.di.scopes.ScopePerScreen;
import iskills.com.memories.ui.adapters.ModuleAdapters;
import iskills.com.memories.ui.addMemory.ModulePresenterAddMemory;
import iskills.com.memories.ui.addMemory.ModuleViewAddMemory;
import iskills.com.memories.ui.addMemory.ViewAddMemory;
import iskills.com.memories.ui.allMemories.ModulePresenterGetAllMemories;
import iskills.com.memories.ui.allMemories.ModuleViewGetAllMemories;
import iskills.com.memories.ui.allMemories.ViewGetAllMemories;
import iskills.com.memories.ui.editMemory.ModulePresenterEditMemory;
import iskills.com.memories.ui.editMemory.ModuleViewEditMemory;
import iskills.com.memories.ui.editMemory.ViewEditMemory;
import iskills.com.memories.ui.map.ModulePresenterMap;
import iskills.com.memories.ui.map.ModuleViewMap;
import iskills.com.memories.ui.map.ViewMap;

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
    @ContributesAndroidInjector(modules = {ModuleViewGetAllMemories.class, ModulePresenterGetAllMemories.class, ModuleAdapters.class})
    abstract ViewGetAllMemories viewGetAllMemories();


    @ScopePerScreen
    @ContributesAndroidInjector(modules = {ModuleViewEditMemory.class, ModulePresenterEditMemory.class})
    abstract ViewEditMemory viewEditMemory();

    @ScopePerScreen
    @ContributesAndroidInjector(modules = {ModuleViewMap.class, ModulePresenterMap.class})
    abstract ViewMap viewMap();

}
