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

  public void saveLokasi(Lokasi lokasi) {
    dataManager.addLokasi(lokasi);
  }
}
