package pratamawijaya.com.amikomandroidarchmateri.data;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pratamawijaya.com.amikomandroidarchmateri.presentation.pojo.Lokasi;

/**
 * Created by pratama
 * Date : Apr - 4/19/17
 * Project Name : AmikomAndroidArchMateri
 *
 *
 * https://github.com/codepath/android_guides/wiki/Clean-Persistence-with-Sugar-ORM
 */

public class DataManager {

  public static final String TAG = "DataManager";

  public void addLokasi(Lokasi lokasi) {
    Log.d(TAG, "addLokasi: insert :" + lokasi.name);
    lokasi.save();
  }

  public List<Lokasi> readAllLokasi() {
    Iterator<Lokasi> lokasiIterator = Lokasi.findAll(Lokasi.class);
    List<Lokasi> lokasiList = new ArrayList<>();

    while (lokasiIterator.hasNext()) {
      lokasiList.add(lokasiIterator.next());
    }

    Log.d(TAG, "readAllLokasi: " + lokasiList.size());
    return lokasiList;
  }

  public void deleteLokasi(Lokasi lokasi) {
    boolean isDeleted = lokasi.delete();
    Log.d(TAG, "deleteLokasi: " + isDeleted);
  }
}
