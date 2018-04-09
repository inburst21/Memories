package iskills.com.memories.ui.adapters;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.di.providers.date.PresenterDate;
import iskills.com.memories.di.scopes.ScopePerScreen;
import iskills.com.memories.ui.allMemories.PresenterMemoryGrid;

/**
 * lennyhicks
 * 4/5/18
 */
@Module
public class ModuleAdapters {


//
//    @QualAdapterMemoryGrid
//    @ScopePerScreen
//    @Provides
//    PresenterMemoryGrid presenterMemoryGrid(){
//        return new PresenterMemoryGrid();
//    }


    @ScopePerScreen
    @Provides
    AdapterMemoryGrid adapterMemoryGrid(PresenterDate date){
        return new AdapterMemoryGrid(new PresenterMemoryGrid(date));
    }
}
