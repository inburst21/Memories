package iskills.com.presentation.di.application;

import dagger.Module;
import dagger.Provides;
import io.reactivex.functions.Function;
import iskills.com.data.MapperImpl;
import iskills.com.data.entities.EntityMemory;
import iskills.com.data.functions.FunctionToEntity;
import iskills.com.data.functions.FunctionToModel;
import iskills.com.domain.model.Memory;
import iskills.com.presentation.di.scopes.ApplicationScope;

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
  MapperImpl implMapper(
      Function<EntityMemory, Memory> entityToModel, Function<Memory, EntityMemory> modelToEntity) {
    return new MapperImpl(entityToModel, modelToEntity);
  }
}
