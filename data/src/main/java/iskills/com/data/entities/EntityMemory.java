package iskills.com.data.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Room-specific Memory Entity data type.
 */
@Entity(tableName = "memories")
public class EntityMemory {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    /**
     * You can you @ColumnInfo to set custom names to tables with Room
     */
    @ColumnInfo(name = "image_bytes")
    public byte[] imageBytes;
    public String comment;
    public long date;
    public double lat;
    public double lng;
    public String address;
    public String title;
    public long uploadTime;

    public EntityMemory(){}

    private EntityMemory(Builder builder) {
        id = builder.id;
        imageBytes = builder.imageBytes;
        comment = builder.comment;
        date = builder.date;
        lat = builder.lat;
        lng = builder.lng;
        address = builder.address;
        title = builder.title;
        uploadTime = builder.uploadTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@code EntityMemory} builder static inner class.
     */
    public static final class Builder {
        private Long id;
        private byte[] imageBytes;
        private String comment;
        private long date;
        private double lat;
        private double lng;
        private String address;
        private String title;
        private long uploadTime;

        private Builder() {
        }

        /**
         * Sets the {@code id} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param id the {@code id} to set
         * @return a reference to this Builder
         */
        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the {@code imageBytes} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param imageBytes the {@code imageBytes} to set
         * @return a reference to this Builder
         */
        public Builder withImageBytes(byte[] imageBytes) {
            this.imageBytes = imageBytes;
            return this;
        }

        /**
         * Sets the {@code comment} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param comment the {@code comment} to set
         * @return a reference to this Builder
         */
        public Builder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Sets the {@code date} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param date the {@code date} to set
         * @return a reference to this Builder
         */
        public Builder withDate(String date) {
            try {
                this.date = SimpleDateFormat.getDateInstance().parse(date).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return this;
        }

        /**
         * Sets the {@code lat} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param lat the {@code lat} to set
         * @return a reference to this Builder
         */
        public Builder withLat(double lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Sets the {@code lng} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param lng the {@code lng} to set
         * @return a reference to this Builder
         */
        public Builder withLng(double lng) {
            this.lng = lng;
            return this;
        }

        /**
         * Sets the {@code address} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param address the {@code address} to set
         * @return a reference to this Builder
         */
        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * Sets the {@code imageTitle} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param title the {@code imageTitle} to set
         * @return a reference to this Builder
         */
        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Sets the {@code uploadTime} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param uploadTime the {@code uploadTime} to set
         * @return a reference to this Builder
         */
        public void withUploadTime(long uploadTime) {
            this.uploadTime = uploadTime;
        }

        /**
         * Returns a {@code EntityMemory} built from the parameters previously set.
         *
         * @return a {@code EntityMemory} built with parameters of this {@code EntityMemory.Builder}
         */
        public EntityMemory build() {
            return new EntityMemory(this);
        }
    }
}