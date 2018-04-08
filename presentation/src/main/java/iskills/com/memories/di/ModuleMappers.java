package iskills.com.memories.di;

import dagger.Module;
import dagger.Provides;
import io.reactivex.functions.Function;
import iskills.com.data.ImplMapper;
import iskills.com.data.entities.EntityMemory;
import iskills.com.data.funtions.FunctionToEntity;
import iskills.com.data.funtions.FunctionToModel;
import iskills.com.domain.model.Memory;

/**
 * lennyhicks
 * 4/7/18
 */
@Module
class ModuleMappers {

    @Provides
    Function<EntityMemory, Memory> functionEntityToModel(){
        return new FunctionToModel();
    }

    @Provides
    Function<Memory, EntityMemory> functionMemoryToEntity(){
        return new FunctionToEntity();
    }

    @Provides
    ImplMapper implMapper(Function<EntityMemory, Memory> entityToModel, Function<Memory, EntityMemory> modelToEntity){
        return new ImplMapper(entityToModel, modelToEntity);
    }

}
