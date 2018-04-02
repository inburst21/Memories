package iskills.com.data.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Room-specific Note Entity data type.
 */
@Entity(tableName = "images")
public class EntityMemory {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    /**
     * You can you @ColumnInfo to set custom names to tables with Room
     */
    @ColumnInfo(name = "image_bytes")
    public byte[] imageBytes;
    public String imageComment;
    public long date;
    public double lat;
    public double lng;
    public String address;
    public String imageTitle;
    public long uploadTime;

    @Ignore
    public EntityMemory(byte[] imageBytes, String title, String comment, long memoryDate, String address, Double lat, Double lng, long uploadTime) {
        this.imageBytes = imageBytes;
        this.imageTitle = title;
        this.imageComment = comment;
        this.address = address;
        this.date = memoryDate;
        this.lat = lat;
        this.lng = lng;
        this.uploadTime = uploadTime;
    }

    public EntityMemory(Long id, byte[] imageBytes, String imageComment, long date, double lat, double lng, String imageTitle) {
        this.id = id;
        this.imageBytes = imageBytes;
        this.imageComment = imageComment;
        this.date = date;
        this.lat = lat;
        this.lng = lng;
        this.imageTitle = imageTitle;
    }
}