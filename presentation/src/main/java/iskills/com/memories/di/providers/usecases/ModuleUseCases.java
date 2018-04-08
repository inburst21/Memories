package iskills.com.memories.di.providers.usecases;

import dagger.Module;
import dagger.Provides;
import iskills.com.domain.repository.RepositoryMemory;
import iskills.com.domain.usecases.UseCaseAddOrUpdateMemory;
import iskills.com.domain.usecases.UseCaseDeleteMemory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.domain.usecases.UseCaseGetMatchingMemories;
import iskills.com.domain.usecases.UseCaseGetMemoryById;
import iskills.com.memories.di.scopes.ScopeAndroid;

/**
 * lennyhicks
 * 4/4/18
 */
@Module
public class ModuleUseCases {

    @ScopeAndroid
    @Provides
    UseCaseGetAllMemories providesGetAllMemories(RepositoryMemory repositoryMemory){
        return new UseCaseGetAllMemories(repositoryMemory);
    }

    @Provides
    UseCaseAddOrUpdateMemory providesUpdateMemory(RepositoryMemory repositoryMemory){
        return new UseCaseAddOrUpdateMemory(repositoryMemory);
    }

    @Provides
    UseCaseDeleteMemory providesDeleteMemory(RepositoryMemory repositoryMemory){
        return new UseCaseDeleteMemory(repositoryMemory);
    }

    @Provides
    UseCaseGetMatchingMemories providesGetMatchingMemories(RepositoryMemory repositoryMemory){
        return new UseCaseGetMatchingMemories(repositoryMemory);
    }

    @Provides
    UseCaseGetMemoryById providesGetMemoryById(RepositoryMemory repositoryMemory){
        return new UseCaseGetMemoryById(repositoryMemory);
    }

}
