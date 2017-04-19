package pratamawijaya.com.amikomandroidarchmateri.presentation.ui.lokasi.presenter;

import pratamawijaya.com.amikomandroidarchmateri.data.DataManager;
import pratamawijaya.com.amikomandroidarchmateri.presentation.pojo.Lokasi;
import pratamawijaya.com.amikomandroidarchmateri.presentation.ui.lokasi.AddActivityView;

/**
 * Created by pratama
 * Date : Apr - 4/19/17
 * Project Name : AmikomAndroidArchMateri
 */

public class AddPresenter {
  private AddActivityView view;
  private DataManager dataManager;

  public AddPresenter(AddActivityView view, DataManager dataManager) {
    this.view = view;
    this.dataManager = dataManager;
  }

  public void saveData(String nama, String desc, float lat, float lng, long time) {
    if (validate(nama, desc)) {
      Lokasi lokasi =
          new Lokasi.Builder().name(nama).deskripsi(desc).lat(lat).lng(lng).timestamp(time).build();
      dataManager.addLokasi(lokasi);
      view.addLokasiSukses();
    }
  }

  private boolean validate(String nama, String desc) {
    if (nama == null || nama.isEmpty()) {
      view.showError("Harap isi data nama lokasi");
      return false;
    } else if (desc == null || desc.isEmpty()) {
      view.showError("Harap isi desc lokasi");
      return false;
    }
    return true;
  }
}
