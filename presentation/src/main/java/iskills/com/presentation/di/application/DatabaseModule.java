package iskills.com.presentation.di.application;

import android.app.Application;
import android.arch.persistence.room.Room;

import dagger.Module;
import dagger.Provides;
import iskills.com.data.MapperImpl;
import iskills.com.data.MemoryDaoImpl;
import iskills.com.data.MemoryDatabase;
import iskills.com.data.MemoryRepositoryImpl;
import iskills.com.domain.repository.MemoryRepository;
import iskills.com.presentation.di.scopes.ApplicationScope;

/** lennyhicks 4/14/18 */
@Module(includes = MapperModule.class)
public class DatabaseModule {
  @ApplicationScope
  @Provides
  MemoryDatabase providesImageDatabase(Application application) {
    return Room.databaseBuilder(application, MemoryDatabase.class, "memoriesdb")
        .build();
  }

  @ApplicationScope
  @Provides
  MemoryDaoImpl provideImageDao(MemoryDatabase memoryDatabase) {
    return memoryDatabase.implImageDao();
  }

  @ApplicationScope
  @Provides
  MemoryRepository provideImageRepository(MemoryDaoImpl dao, MapperImpl modelMapper) {
    return new MemoryRepositoryImpl(dao, modelMapper);
  }
}
