package iskills.com.data;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.flowables.ConnectableFlowable;
import iskills.com.data.entities.EntityMemory;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */

public class ImplImageRepository implements RepositoryMemory {

    private ImplImageDao implImageDao;
    private ImplMapper mapper;

    private List<Memory> memoriesFresh = new ArrayList<>();

    public ImplImageRepository(ImplImageDao implImageDao, ImplMapper mapper) {
        this.implImageDao = implImageDao;
        this.mapper = mapper;
    }

    @Override
    public Completable addMemory(final @NonNull Memory memory) {
        EntityMemory entityMemory = null;
        try {
            entityMemory = mapper.toEntity.apply(memory);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (entityMemory != null) {
            EntityMemory finalEntityMemory = entityMemory;
            return Completable.fromAction(() ->
                    implImageDao.insertImage(finalEntityMemory));
        } else return Completable.error(new Exception());
    }

    @Override
    public ConnectableFlowable<List<Memory>> getAllMemories() {
        List<EntityMemory> entityMemories = implImageDao.getAllImages();

        memoriesFresh = mapper.memoriesFromList(entityMemories);


        return Flowable.fromArray(memoriesFresh).publish();
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
