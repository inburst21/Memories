package iskills.com.memoriesrefactor.di.application;

import android.app.Application;
import android.arch.persistence.room.Room;

import dagger.Module;
import dagger.Provides;
import iskills.com.data.DatabaseImage;
import iskills.com.data.ImplImageDao;
import iskills.com.data.ImplImageRepository;
import iskills.com.data.ImplMapper;
import iskills.com.domain.repository.RepositoryMemory;
import iskills.com.memoriesrefactor.di.scopes.ApplicationScope;

/**
 * lennyhicks
 * 4/14/18
 */
@Module(includes = MapperModule.class)
public class DatabaseModule {
    @ApplicationScope
    @Provides
    DatabaseImage providesImageDatabase(Application application) {
        return Room.databaseBuilder(application, DatabaseImage.class, "imagedb").fallbackToDestructiveMigration().build();
    }

    @ApplicationScope
    @Provides
    ImplImageDao provideImageDao(DatabaseImage databaseImage) {
        return databaseImage.implImageDao();
    }

    @ApplicationScope
    @Provides
    RepositoryMemory provideImageRepository(ImplImageDao dao, ImplMapper modelMapper) {
        return new ImplImageRepository(dao, modelMapper);
    }
}
