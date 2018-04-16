package iskills.com.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import iskills.com.data.entities.EntityMemory;

/**
 * lennyhicks
 * 3/30/18
 */

@Dao
public interface ImplImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertImage(EntityMemory imageEntity);

    @Query("SELECT * FROM memories Order by date DESC")
    Flowable<List<EntityMemory>> getAllImages();

    @Query("SELECT * FROM memories WHERE id LIKE :id")
    Single<EntityMemory> getMemoryById(Long id);

    @Update
    void updateImage(EntityMemory imageEntity);

    @Delete
    void deleteImage(EntityMemory imageEntity);
}
