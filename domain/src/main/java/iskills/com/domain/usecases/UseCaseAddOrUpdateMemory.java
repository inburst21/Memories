package iskills.com.domain.usecases;

import io.reactivex.Completable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.MemoryRepository;
import iskills.com.domain.validators.MemoryValidator;

/**
 * lennyhicks
 * 3/30/18
 */
public class UseCaseAddOrUpdateMemory {
    private final MemoryRepository memoryRepository;
    private final MemoryValidator memoryValidator;

    public UseCaseAddOrUpdateMemory(MemoryRepository repositoryImage, MemoryValidator memoryValidator) {
        this.memoryRepository = repositoryImage;
        this.memoryValidator = memoryValidator;
    }

    public Completable addOrUpdate(Memory memory) {
        return validate(memory);
    }


    private Completable validate(Memory memory) {
        if (!memoryValidator.validate(memory)) {
            return Completable.error(new IllegalArgumentException("Memory failed validation"));
        } else {
            if (memory.id == null) {
                return Completable.complete().andThen(memoryRepository.addMemory(memory));
            } else {
                return Completable.complete().andThen(memoryRepository.updateMemory(memory));
            }

        }
    }
}
