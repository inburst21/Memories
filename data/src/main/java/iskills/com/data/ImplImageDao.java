package iskills.com.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Single;
import iskills.com.data.entities.EntityMemory;
import iskills.com.domain.repository.ImageDao;

/**
 * lennyhicks
 * 3/30/18
 */

@Dao
public interface ImplImageDao extends ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertImage(EntityMemory imageEntity);

    @Query("SELECT * FROM images")
    Single<List<EntityMemory>> getAllImages();

    @Query("SELECT * FROM images WHERE imageTitle LIKE :title AND imageComment LIKE :comment")
    Single<List<EntityMemory>> getMatchingImage(String title, String comment);

    @Update
    void updateImage(EntityMemory imageEntity);

    @Delete
    void deleteImage(EntityMemory imageEntity);
}
