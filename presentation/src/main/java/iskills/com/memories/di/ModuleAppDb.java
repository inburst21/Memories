package iskills.com.memories.di;

import android.arch.persistence.room.Room;

import dagger.Module;
import dagger.Provides;
import iskills.com.data.DatabaseImage;
import iskills.com.data.ImplImageDao;
import iskills.com.data.ImplImageRepository;
import iskills.com.data.ImplMapper;
import iskills.com.domain.repository.RepositoryMemory;
import iskills.com.memories.MainActivity;
import iskills.com.memories.di.scopes.ScopeAndroid;

/**
 * lennyhicks
 * 3/30/18
 */

@Module(includes = ModuleMappers.class)
class ModuleAppDb {

    @ScopeAndroid
    @Provides
    DatabaseImage providesImageDatabase(MainActivity context){
        return Room.databaseBuilder(context, DatabaseImage.class, "imagedb").fallbackToDestructiveMigration().build();
    }

    @ScopeAndroid
    @Provides
    ImplImageDao provideImageDao(DatabaseImage databaseImage){
        return databaseImage.implImageDao();
    }

    @ScopeAndroid
    @Provides
    RepositoryMemory provideImageRepository(ImplImageDao dao, ImplMapper modelMapper){
        return new ImplImageRepository(dao, modelMapper);
    }

}
