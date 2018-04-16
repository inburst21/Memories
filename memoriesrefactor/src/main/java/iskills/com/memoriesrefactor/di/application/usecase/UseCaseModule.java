package iskills.com.memoriesrefactor.di.application.usecase;

import dagger.Module;
import dagger.Provides;
import iskills.com.domain.repository.RepositoryMemory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;

/**
 * lennyhicks
 * 4/15/18
 */
@Module
public class UseCaseModule {

    @Provides
    public UseCaseGetAllMemories getAllMemories(RepositoryMemory repositoryMemory) {
        return new UseCaseGetAllMemories(repositoryMemory);
    }

}
