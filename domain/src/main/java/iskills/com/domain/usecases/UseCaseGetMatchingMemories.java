package iskills.com.domain.usecases;

import java.util.List;

import io.reactivex.Observable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */
public class UseCaseGetMatchingMemories {
    private RepositoryMemory repositoryMemory;

    UseCaseGetMatchingMemories(RepositoryMemory repositoryImage) {
        this.repositoryMemory = repositoryImage;
    }

    Observable<List<Memory>> getMatchingMemories(final String title, final String comment) {
        return repositoryMemory.getMatchingImage(title, comment);
    }
}
