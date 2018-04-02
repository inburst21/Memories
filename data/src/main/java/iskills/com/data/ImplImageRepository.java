package iskills.com.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import iskills.com.data.entities.EntityMemory;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */

public class ImplImageRepository implements RepositoryMemory {

    private ImplImageDao implImageDao;
    private ImplImageModelMapper implImageModelMapper;

    public ImplImageRepository(ImplImageDao implImageDao, ImplImageModelMapper implImageModelMapper){
        this.implImageDao = implImageDao;
        this.implImageModelMapper = implImageModelMapper;
    }

    @Override
    public Completable addPhoto(final Memory memory) {
        EntityMemory entityMemory = implImageModelMapper.toEntity(memory);
        entityMemory.uploadTime = System.currentTimeMillis();
        return Completable.fromAction(() ->
                implImageDao.insertImage(entityMemory));
    }

    @Override
    public Observable<List<Memory>> getAllImages() {
        return implImageDao.getAllImages()
                .toFlowable()
                .flatMapIterable(entityImages -> entityImages)
                .map(implImageModelMapper::fromEntity)
                .toList()
                .toObservable();
    }

    @Override
    public Observable<List<Memory>> getMatchingImage(String title, String comment) {
        return implImageDao.getMatchingImage(title, comment)
                .toFlowable()
                .flatMapIterable(entityImages -> entityImages)
                .map(implImageModelMapper::fromEntity)
                .toList().toObservable();
    }

    @Override
    public Completable updateImage(Memory memory) {
        return Completable.fromAction(() ->
                implImageDao.updateImage(implImageModelMapper.toEntity(memory)));
    }

    @Override
    public Completable deleteImage(Memory memory) {
        return Completable.fromAction(() ->
                implImageDao.deleteImage(implImageModelMapper.toEntity(memory)));
    }

}
