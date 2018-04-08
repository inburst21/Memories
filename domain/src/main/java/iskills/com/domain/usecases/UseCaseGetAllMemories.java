package iskills.com.domain.usecases;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.flowables.ConnectableFlowable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */
public class UseCaseGetAllMemories {
    private RepositoryMemory repositoryMemory;
    private List<Memory> memories1 = new ArrayList<>();

    public UseCaseGetAllMemories(RepositoryMemory repositoryImage) {
        this.repositoryMemory = repositoryImage;
    }

    public ConnectableFlowable<List<Memory>> getAllMemories() {
        return repositoryMemory
                .getAllMemories()
                .autoConnect()
                .replay();

    }

}
