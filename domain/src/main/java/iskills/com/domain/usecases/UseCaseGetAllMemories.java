package iskills.com.domain.usecases;

import java.util.List;

import io.reactivex.Flowable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.MemoryRepository;

/**
 * lennyhicks
 * 3/30/18
 */
public class UseCaseGetAllMemories {
    private MemoryRepository memoryRepository;

    public UseCaseGetAllMemories(MemoryRepository repositoryImage) {
        this.memoryRepository = repositoryImage;
    }

    public Flowable<List<Memory>> getAllMemories() {
        return memoryRepository
                .getAllMemories();

    }

}
