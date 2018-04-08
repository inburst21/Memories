package iskills.com.domain.repository;

/**
 * lennyhicks
 * 3/29/18
 */

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.flowables.ConnectableFlowable;
import iskills.com.domain.model.Memory;

/**
 * Repository interface to be implemented by Data layer.
 */
public interface RepositoryMemory {
    Completable addMemory(Memory memory);
    Completable updateMemory(Memory memoryEntity);
    Completable deleteMemory(Memory memoryEntity);

    ConnectableFlowable<List<Memory>> getAllMemories();
    Flowable<List<Memory>> getMatchingMemories(String title, String comment);

    Observable<Memory> getMemoryById(Long id);
}
