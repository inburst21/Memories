package iskills.com.memories.ui.addMemory;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import iskills.com.domain.repository.RepositoryMemory;
import iskills.com.domain.usecases.UseCaseAddMemory;
import iskills.com.memories.di.ScopePerScreen;
import iskills.com.memories.di.qualifiers.MainThread;
import iskills.com.memories.di.qualifiers.UiThread;

/**
 * lennyhicks
 * 3/30/18
 */
@Module
public class ModulePresenterAddMemory {

    @Provides
    @ScopePerScreen
    UseCaseAddMemory providesUseCase(RepositoryMemory repositoryMemory){
        return new UseCaseAddMemory(repositoryMemory);
    }

    @Provides
    @ScopePerScreen
    PresenterAddMemory providesPresenterAddMemory(ContractAddMemory.View view, UseCaseAddMemory useCaseAddMemory, @MainThread Scheduler main, @UiThread Scheduler ui){
        return new PresenterAddMemory(view, useCaseAddMemory, main, ui);
    }
}
