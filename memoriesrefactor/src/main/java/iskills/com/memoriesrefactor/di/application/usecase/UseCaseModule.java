package iskills.com.memoriesrefactor.di.application.usecase;

import dagger.Module;
import dagger.Provides;
import iskills.com.domain.repository.RepositoryMemory;
import iskills.com.domain.usecases.UseCaseAddOrUpdateMemory;
import iskills.com.domain.usecases.UseCaseDeleteMemory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.domain.usecases.UseCaseGetMemoryById;

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

    @Provides
    public UseCaseAddOrUpdateMemory addOrUpdateMemory(RepositoryMemory repositoryMemory) {
        return new UseCaseAddOrUpdateMemory(repositoryMemory);
    }

    @Provides
    public UseCaseGetMemoryById useCaseGetMemoryById(RepositoryMemory repositoryMemory) {
        return new UseCaseGetMemoryById(repositoryMemory);
    }

    @Provides
    public UseCaseDeleteMemory useCaseDeleteMemory(RepositoryMemory repositoryMemory) {
        return new UseCaseDeleteMemory(repositoryMemory);
    }

}
