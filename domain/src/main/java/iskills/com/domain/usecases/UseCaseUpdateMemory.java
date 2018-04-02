package iskills.com.domain.usecases;

import io.reactivex.Completable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */
public class UseCaseUpdateMemory {
    private RepositoryMemory repositoryMemory;

    UseCaseUpdateMemory(RepositoryMemory repositoryImage) {
        this.repositoryMemory = repositoryImage;
    }

    Completable update(Memory memory) {
        return repositoryMemory.updateImage(memory);
    }


}
