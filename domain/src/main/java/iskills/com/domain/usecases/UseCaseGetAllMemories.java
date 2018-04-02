package iskills.com.domain.usecases;

import java.util.List;

import io.reactivex.Observable;
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

    public Observable<List<Memory>> getAllMemories() {
        return repositoryMemory.getAllImages();
    }

}
