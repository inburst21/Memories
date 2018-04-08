package iskills.com.domain.usecases;

import io.reactivex.Observable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 4/6/18
 */
public class UseCaseGetMemoryById {
    private RepositoryMemory repositoryMemory;

    public UseCaseGetMemoryById(RepositoryMemory repositoryImage) {
        this.repositoryMemory = repositoryImage;
    }

    public Observable<Memory> getMemoryById(Long id) {
        return repositoryMemory.getMemoryById(id);
    }
}
