package iskills.com.domain.model;

import java.util.Calendar;

/**
 * lennyhicks
 * 3/29/18
 */

public class Memory {
    public Long id;
    public byte[] imageBytes;
    public String title = "";
    public String comment = "";
    public Calendar memoryDate = Calendar.getInstance();
    public String address;
    public Double lat;
    public Double lng;

    public Memory() {
    }

    public Memory(Long id, byte[] imageBytes, String title, String comment, long memoryDate, String address, Double lat, Double lng) {
        this.id = id;
        this.imageBytes = imageBytes;
        this.title = title;
        this.comment = comment;
        this.setDate(memoryDate);
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    public Memory(byte[] imageBytes, String title, String comment, long memoryDate, String address, Double lat, Double lng) {

        this.imageBytes = imageBytes;
        this.title = title;
        this.comment = comment;
        this.setDate(memoryDate);
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public boolean isValid() {
        return (imageBytes != null || !title.isEmpty() || !comment.isEmpty() || memoryDate != null || lat != null || lng != null);
    }

    public Calendar getTime() {
        return memoryDate;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setDate(long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        this.memoryDate = calendar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Calendar getMemoryDate() {
        return memoryDate;
    }

    public void setMemoryDate(Calendar memoryDate) {
        this.memoryDate = memoryDate;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
