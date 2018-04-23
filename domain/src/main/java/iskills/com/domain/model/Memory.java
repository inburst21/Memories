package iskills.com.domain.model;

import java.text.SimpleDateFormat;

/** lennyhicks 3/29/18 */
public class Memory {

  public Long id;
  public String title;
  public String comment;
  public String address;

  public byte[] imageBytes;
  public String memoryDate;
  public Double lat;
  public Double lng;

  @Override
  public String toString() {
    return "Memory{"
        + "id="
        + id
        + ", title='"
        + title
        + '\''
        + ", comment='"
        + comment
        + '\''
        + ", address='"
        + address
        + '\''
        + ", lat="
        + lat
        + ", lng="
        + lng
        + '}';
  }

  public Memory() {}

  private Memory(Builder builder) {
    id = builder.id;
    imageBytes = builder.imageBytes;
    title = builder.title;
    comment = builder.comment;
    memoryDate = builder.memoryDate;
    address = builder.address;
    lat = builder.lat;
    lng = builder.lng;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /** {@code Memory} builder static inner class. */
  public static final class Builder {
    private Long id;
    private byte[] imageBytes;
    private String title;
    private String comment;
    private String memoryDate;
    private String address;
    private Double lat;
    private Double lng;

    private Builder() {}

    /**
     * Sets the {@code id} and returns a reference to this Builder so that the methods can be
     * chained together.
     *
     * @param id the {@code id} to set
     * @return a reference to this Builder
     */
    public Builder withId(Long id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the {@code imageBytes} and returns a reference to this Builder so that the methods can
     * be chained together.
     *
     * @param imageBytes the {@code imageBytes} to set
     * @return a reference to this Builder
     */
    public Builder withImageBytes(byte[] imageBytes) {
      this.imageBytes = imageBytes;
      return this;
    }

    /**
     * Sets the {@code title} and returns a reference to this Builder so that the methods can be
     * chained together.
     *
     * @param title the {@code title} to set
     * @return a reference to this Builder
     */
    public Builder withTitle(String title) {
      this.title = title;
      return this;
    }

    /**
     * Sets the {@code comment} and returns a reference to this Builder so that the methods can be
     * chained together.
     *
     * @param comment the {@code comment} to set
     * @return a reference to this Builder
     */
    public Builder withComment(String comment) {
      this.comment = comment;
      return this;
    }

    /**
     * Sets the {@code memoryDate} and returns a reference to this Builder so that the methods can
     * be chained together.
     *
     * @param memoryDate the {@code memoryDate} to set
     * @return a reference to this Builder
     */
    public Builder withMemoryDate(long memoryDate) {
      this.memoryDate = SimpleDateFormat.getDateInstance().format(memoryDate);;
      return this;
    }

    /**
     * Sets the {@code address} and returns a reference to this Builder so that the methods can be
     * chained together.
     *
     * @param address the {@code address} to set
     * @return a reference to this Builder
     */
    public Builder withAddress(String address) {
      this.address = address;
      return this;
    }

    /**
     * Sets the {@code lat} and returns a reference to this Builder so that the methods can be
     * chained together.
     *
     * @param lat the {@code lat} to set
     * @return a reference to this Builder
     */
    public Builder withLat(Double lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Sets the {@code lng} and returns a reference to this Builder so that the methods can be
     * chained together.
     *
     * @param lng the {@code lng} to set
     * @return a reference to this Builder
     */
    public Builder withLng(Double lng) {
      this.lng = lng;
      return this;
    }

    /**
     * Returns a {@code Memory} built from the parameters previously set.
     *
     * @return a {@code Memory} built with parameters of this {@code Memory.Builder}
     */
    public Memory build() {
      return new Memory(this);
    }
  }
}
