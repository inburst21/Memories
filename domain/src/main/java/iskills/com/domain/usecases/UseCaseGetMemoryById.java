package iskills.com.domain.usecases;

import io.reactivex.Single;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.MemoryRepository;

/**
 * lennyhicks
 * 4/6/18
 */
public class UseCaseGetMemoryById {
    private MemoryRepository memoryRepository;

    public UseCaseGetMemoryById(MemoryRepository repositoryImage) {
        this.memoryRepository = repositoryImage;
    }

    public Single<Memory> getMemoryById(Long id) {
        return memoryRepository.getMemoryById(id);
    }
}
