package iskills.com.domain.usecases;

import io.reactivex.Completable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.MemoryRepository;

/**
 * lennyhicks
 * 3/30/18
 */

public class UseCaseDeleteMemory {
    private final MemoryRepository memoryRepository;

    public UseCaseDeleteMemory(MemoryRepository repositoryImage) {
        this.memoryRepository = repositoryImage;
    }

    public Completable delete(Memory memory) {
        return memoryRepository.deleteMemory(memory);
    }


}
