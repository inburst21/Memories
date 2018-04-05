package iskills.com.memories.di.providers.usecases;

import dagger.Module;
import dagger.Provides;
import iskills.com.domain.repository.RepositoryMemory;
import iskills.com.domain.usecases.UseCaseAddMemory;
import iskills.com.domain.usecases.UseCaseDeleteMemory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.domain.usecases.UseCaseGetMatchingMemories;
import iskills.com.domain.usecases.UseCaseUpdateMemory;
import iskills.com.memories.di.scopes.ScopeAndroid;

/**
 * lennyhicks
 * 4/4/18
 */
@Module
public class ModuleUseCases {
    @Provides
    @ScopeAndroid
    UseCaseAddMemory providesUseCase(RepositoryMemory repositoryMemory){
        return new UseCaseAddMemory(repositoryMemory);
    }

    @Provides
    UseCaseGetAllMemories providesGetAllMemories(RepositoryMemory repositoryMemory){
        return new UseCaseGetAllMemories(repositoryMemory);
    }

    @Provides
    UseCaseUpdateMemory providesUpdateMemory(RepositoryMemory repositoryMemory){
        return new UseCaseUpdateMemory(repositoryMemory);
    }

    @Provides
    UseCaseDeleteMemory providesDeleteMemory(RepositoryMemory repositoryMemory){
        return new UseCaseDeleteMemory(repositoryMemory);
    }

    @Provides
    UseCaseGetMatchingMemories providesGetMatchingMemories(RepositoryMemory repositoryMemory){
        return new UseCaseGetMatchingMemories(repositoryMemory);
    }

}
