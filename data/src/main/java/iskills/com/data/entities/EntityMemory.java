package iskills.com.data.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Room-specific Note Entity data type.
 */
@Entity
public class EntityMemory {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    /**
     * You can you @ColumnInfo to set custom names to tables with Room
     */
    @ColumnInfo(name = "image_bytes")
    public byte[] imageBytes;
//    public String comment;
//    public long date;
//    public double lat;
//    public double lng;
//    public String address;
//    public String title;
//    public long uploadTime;

}