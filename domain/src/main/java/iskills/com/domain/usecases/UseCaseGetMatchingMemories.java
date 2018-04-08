package iskills.com.domain.usecases;

import java.util.List;

import io.reactivex.Flowable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */
public class UseCaseGetMatchingMemories {
    private RepositoryMemory repositoryMemory;

    public UseCaseGetMatchingMemories(RepositoryMemory repositoryImage) {
        this.repositoryMemory = repositoryImage;
    }

    Flowable<List<Memory>> getMatchingMemories(final String title, final String comment) {
        return repositoryMemory.getMatchingMemories(title, comment);
    }
}
