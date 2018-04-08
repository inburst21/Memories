package iskills.com.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import iskills.com.data.entities.EntityMemory;

/**
 * lennyhicks
 * 3/30/18
 */

@Database(version = 9, entities = EntityMemory.class)
public abstract class DatabaseImage extends RoomDatabase {
    abstract public ImplImageDao implImageDao();


    private static DatabaseImage INSTANCE;


    public static DatabaseImage getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseImage.class, "memorydb")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}


