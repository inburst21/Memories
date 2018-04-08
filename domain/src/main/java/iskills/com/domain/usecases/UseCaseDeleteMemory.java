package iskills.com.domain.usecases;

import io.reactivex.Completable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */

public class UseCaseDeleteMemory {
    private RepositoryMemory repositoryMemory;

    public UseCaseDeleteMemory(RepositoryMemory repositoryImage) {
        this.repositoryMemory = repositoryImage;
    }

    Completable delete(Memory memory) {
        return repositoryMemory.deleteMemory(memory);
    }


}
