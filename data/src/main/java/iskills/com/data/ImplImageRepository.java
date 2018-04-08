package iskills.com.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */

public class ImplImageRepository implements RepositoryMemory {

    private ImplImageDao implImageDao;
    private ImplMapper mapper;

    public ImplImageRepository(ImplImageDao implImageDao, ImplMapper mapper) {
        this.implImageDao = implImageDao;
        this.mapper = mapper;
    }

    @Override
    public Completable addMemory(final @NonNull Memory memory) {

        return Completable.fromAction(() ->
                implImageDao.insertImage(mapper.toEntity.apply(memory)));

    }

    @Override
    public Flowable<List<Memory>> getAllMemories() {
        return implImageDao.getAllImages()
                .map(list -> mapper.memoriesFromList(list));
    }

    @Override
    public Flowable<List<Memory>> getMatchingMemories(String title, String comment) {
        return implImageDao.getMatchingImage()
                .map(mapper.toMemory)
                .toList().toFlowable();
    }

    @Override
    public Observable<Memory> getMemoryById(Long id) {
        return implImageDao.getMemoryById(id)
                .map(mapper.toMemory)
                .toObservable();
    }


    @Override
    public Completable updateMemory(Memory memory) {
        return Completable.fromAction(() ->
                implImageDao.updateImage(mapper.toEntity.apply(memory)));
    }

    @Override
    public Completable deleteMemory(Memory memory) {
        return Completable.fromAction(() ->
                implImageDao.deleteImage(mapper.toEntity.apply(memory)));
    }

}
