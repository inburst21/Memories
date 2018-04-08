package iskills.com.domain.usecases;

import io.reactivex.Completable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */
public class UseCaseAddOrUpdateMemory {
    private RepositoryMemory repositoryMemory;

    public UseCaseAddOrUpdateMemory(RepositoryMemory repositoryImage) {
        this.repositoryMemory = repositoryImage;
    }

    public Completable addOrUpdate(Memory memory) {
        return validate(memory);
    }


    private Completable validate(Memory memory){
        if(!memory.isValid()){
            return Completable.error(new IllegalArgumentException("Memory failed validation"));
        }
        else {
            if(repositoryMemory.getMemoryById(memory.id) != null) {
                return Completable.complete().andThen(repositoryMemory.updateMemory(memory));
            } else {
                return Completable.complete().andThen(repositoryMemory.addMemory(memory));
            }
        }
    }
}
