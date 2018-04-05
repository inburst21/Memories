package iskills.com.memories.ui.allMemories;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.memories.di.qualifiers.MainThread;
import iskills.com.memories.di.qualifiers.UiThread;
import iskills.com.memories.di.scopes.ScopePerScreen;

/**
 * lennyhicks
 * 4/1/18
 */

@Module
public class ModulePresenterGetAllMemories {

    @Provides
    @ScopePerScreen
    PresenterGetAllMemories providesPresenterAddMemory(ContractGetAllMemories.View view, UseCaseGetAllMemories useCaseGetAllMemories, @MainThread Scheduler main, @UiThread Scheduler ui) {
        return new PresenterGetAllMemories(view, useCaseGetAllMemories, main, ui);
    }

}
