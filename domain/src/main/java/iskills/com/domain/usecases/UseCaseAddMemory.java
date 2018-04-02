package iskills.com.domain.usecases;

import io.reactivex.Completable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */

public class UseCaseAddMemory {
    private RepositoryMemory repositoryMemory;

    public UseCaseAddMemory(RepositoryMemory repositoryImage){
        this.repositoryMemory = repositoryImage;
    }

    public Completable add(Memory memory) { return validate(memory).andThen(repositoryMemory.addPhoto(memory)); }

    private Completable validate(Memory memory){
        if(!memory.isValid()){
            return Completable.error(new IllegalArgumentException("Memory failed validation"));
        }
        else {
            return Completable.complete();
        }
    }
}
