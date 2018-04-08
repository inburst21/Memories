package iskills.com.domain.usecases;

import java.util.List;

import io.reactivex.Flowable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */
public class UseCaseGetAllMemories {
    private RepositoryMemory repositoryMemory;

    public UseCaseGetAllMemories(RepositoryMemory repositoryImage) {
        this.repositoryMemory = repositoryImage;
    }

    public Flowable<List<Memory>> getAllMemories() {
        return repositoryMemory
                .getAllMemories();

    }

}
