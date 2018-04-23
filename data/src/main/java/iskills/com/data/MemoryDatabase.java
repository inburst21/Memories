package iskills.com.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import iskills.com.data.entities.EntityMemory;

/**
 * lennyhicks
 * 3/30/18
 */

@Database(version = 11, entities = EntityMemory.class)
public abstract class MemoryDatabase extends RoomDatabase {
    abstract public MemoryDaoImpl implImageDao();
}


