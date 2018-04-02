package iskills.com.memories.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iskills.com.data.DatabaseImage;
import iskills.com.data.ImplImageDao;
import iskills.com.data.ImplImageModelMapper;
import iskills.com.data.ImplImageRepository;
import iskills.com.domain.repository.RepositoryMemory;

/**
 * lennyhicks
 * 3/30/18
 */

@Module
class ModuleAppDb {

    @Singleton
    @Provides
    DatabaseImage providesImageDatabase(Context context){
        return Room.databaseBuilder(context, DatabaseImage.class, "imagedb").fallbackToDestructiveMigration().build();
    }

    @Singleton
    @Provides
    ImplImageDao provideImageDao(DatabaseImage databaseImage){
        return databaseImage.implImageDao();
    }

    @Singleton
    @Provides
    ImplImageModelMapper providesImageModelMapper()
    {
        return new ImplImageModelMapper();
    }

    @Singleton
    @Provides
    RepositoryMemory provideImageRepository(ImplImageDao dao, ImplImageModelMapper modelMapper){
        return new ImplImageRepository(dao, modelMapper);
    }
}
