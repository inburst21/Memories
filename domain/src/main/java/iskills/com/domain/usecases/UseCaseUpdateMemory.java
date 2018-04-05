package iskills.com.domain.usecases;

import io.reactivex.Completable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */
public class UseCaseUpdateMemory {
    private RepositoryMemory repositoryMemory;

    public UseCaseUpdateMemory(RepositoryMemory repositoryImage) {
        this.repositoryMemory = repositoryImage;
    }

    Completable update(Memory memory) {
        return validate(memory);
    }


    private Completable validate(Memory memory){
        if(!memory.isValid()){
            return Completable.error(new IllegalArgumentException("Memory failed validation"));
        }
        else {
            return Completable.complete().andThen(repositoryMemory.addPhoto(memory));
        }
    }


}
