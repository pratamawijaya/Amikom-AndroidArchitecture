package pratamawijaya.com.amikomandroidarchmateri;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;
import java.util.Date;

/**
 * Created by pratama
 * Date : Apr - 4/19/17
 * Project Name : AmikomAndroidArchMateri
 */

public class Lokasi extends SugarRecord {
  public String name;
  public String deskripsi;
  public float lat;
  public float lng;
  public Date createdDate;
  @Unique public long timestamp;

  public Lokasi() {
  }

  private Lokasi(Builder builder) {
    name = builder.name;
    deskripsi = builder.deskripsi;
    lat = builder.lat;
    lng = builder.lng;
    createdDate = builder.createdDate;
    timestamp = builder.timestamp;
  }

  public static final class Builder {
    private String name;
    private String deskripsi;
    private float lat;
    private float lng;
    private Date createdDate;
    private long timestamp;

    public Builder() {
    }

    public Builder name(String val) {
      name = val;
      return this;
    }

    public Builder deskripsi(String val) {
      deskripsi = val;
      return this;
    }

    public Builder lat(float val) {
      lat = val;
      return this;
    }

    public Builder lng(float val) {
      lng = val;
      return this;
    }

    public Builder createdDate(Date val) {
      createdDate = val;
      return this;
    }

    public Builder timestamp(long val) {
      timestamp = val;
      return this;
    }

    public Lokasi build() {
      return new Lokasi(this);
    }
  }
}
