package iskills.com.memoriesrefactor.di.application;

import dagger.Module;
import dagger.Provides;
import io.reactivex.functions.Function;
import iskills.com.data.ImplMapper;
import iskills.com.data.entities.EntityMemory;
import iskills.com.data.functions.FunctionToEntity;
import iskills.com.data.functions.FunctionToModel;
import iskills.com.domain.model.Memory;
import iskills.com.memoriesrefactor.di.scopes.ApplicationScope;

/** lennyhicks 4/14/18 */
@Module
public class MapperModule {
  @ApplicationScope
  @Provides
  Function<EntityMemory, Memory> functionEntityToModel() {
    return new FunctionToModel();
  }

  @ApplicationScope
  @Provides
  Function<Memory, EntityMemory> functionMemoryToEntity() {
    return new FunctionToEntity();
  }

  @ApplicationScope
  @Provides
  ImplMapper implMapper(
      Function<EntityMemory, Memory> entityToModel, Function<Memory, EntityMemory> modelToEntity) {
    return new ImplMapper(entityToModel, modelToEntity);
  }
}
