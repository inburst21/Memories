package iskills.com.presentation.di.application.usecase;

import dagger.Module;
import dagger.Provides;
import iskills.com.domain.repository.MemoryRepository;
import iskills.com.domain.usecases.UseCaseAddOrUpdateMemory;
import iskills.com.domain.usecases.UseCaseDeleteMemory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.domain.usecases.UseCaseGetMemoryById;
import iskills.com.domain.validators.MemoryValidator;

/**
 * lennyhicks
 * 4/15/18
 */
@Module
public class UseCaseModule {

    @Provides
    public UseCaseGetAllMemories getAllMemories(MemoryRepository memoryRepository) {
        return new UseCaseGetAllMemories(memoryRepository);
    }

    @Provides
    public UseCaseAddOrUpdateMemory addOrUpdateMemory(MemoryRepository memoryRepository, MemoryValidator memoryValidator) {
        return new UseCaseAddOrUpdateMemory(memoryRepository, memoryValidator);
    }

    @Provides
    public UseCaseGetMemoryById useCaseGetMemoryById(MemoryRepository memoryRepository) {
        return new UseCaseGetMemoryById(memoryRepository);
    }

    @Provides
    public UseCaseDeleteMemory useCaseDeleteMemory(MemoryRepository memoryRepository) {
        return new UseCaseDeleteMemory(memoryRepository);
    }

}
