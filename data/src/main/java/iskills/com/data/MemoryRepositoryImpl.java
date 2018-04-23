package iskills.com.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.MemoryRepository;

/**
 * lennyhicks
 * 3/30/18
 */

public class MemoryRepositoryImpl implements MemoryRepository {

    private MemoryDaoImpl memoryDaoImpl;
    private MapperImpl mapper;

    public MemoryRepositoryImpl(MemoryDaoImpl memoryDaoImpl, MapperImpl mapper) {
        this.memoryDaoImpl = memoryDaoImpl;
        this.mapper = mapper;
    }

    @Override
    public Completable addMemory(final @NonNull Memory memory) {
        return Completable.fromAction(() ->
                memoryDaoImpl.insertImage(mapper.toEntity.apply(memory)));

    }

    @Override
    public Flowable<List<Memory>> getAllMemories() {
        return memoryDaoImpl.getAllImages()
                .map(list -> mapper.memoriesFromList(list));
    }

    @Override
    public Single<Memory> getMemoryById(Long id) {
        return memoryDaoImpl.getMemoryById(id)
                .map(mapper.toMemory);
    }

    @Override
    public Completable updateMemory(Memory memory) {
        return Completable.fromAction(() ->
                memoryDaoImpl.updateImage(mapper.toEntity.apply(memory)));
    }

    @Override
    public Completable deleteMemory(Memory memory) {
        return Completable.fromAction(() ->
                memoryDaoImpl.deleteImage(mapper.toEntity.apply(memory)));
    }

}
