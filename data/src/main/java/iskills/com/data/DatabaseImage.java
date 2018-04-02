package iskills.com.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import iskills.com.data.entities.EntityMemory;

/**
 * lennyhicks
 * 3/30/18
 */

@Database(entities = EntityMemory.class, version = 2, exportSchema = false)
public abstract class DatabaseImage extends RoomDatabase {
    public abstract ImplImageDao implImageDao();
}


