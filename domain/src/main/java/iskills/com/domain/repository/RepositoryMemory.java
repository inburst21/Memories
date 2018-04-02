package iskills.com.domain.repository;

/**
 * lennyhicks
 * 3/29/18
 */

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import iskills.com.domain.model.Memory;

/**
 * Repository interface to be implemented by Data layer.
 */
public interface RepositoryMemory {
    Completable addPhoto(Memory memory);
    Completable updateImage(Memory memoryEntity);
    Completable deleteImage(Memory memoryEntity);

    Observable<List<Memory>> getAllImages();
    Observable<List<Memory>> getMatchingImage(String title, String comment);
}
