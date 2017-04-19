package pratamawijaya.com.amikomandroidarchmateri.presentation.ui.home.presenter;

import java.util.List;
import pratamawijaya.com.amikomandroidarchmateri.data.DataManager;
import pratamawijaya.com.amikomandroidarchmateri.presentation.pojo.Lokasi;
import pratamawijaya.com.amikomandroidarchmateri.presentation.ui.home.MainView;

/**
 * Created by pratama
 * Date : Apr - 4/19/17
 * Project Name : AmikomAndroidArchMateri
 */
public class MainPresenter {
  private static final String TAG = MainPresenter.class.getName();
  private MainView view;
  private DataManager dataManager;

  public MainPresenter(MainView view, DataManager dataManager) {
    this.view = view;
    this.dataManager = dataManager;
  }

  public void getDataLokasi() {
    List<Lokasi> dataFromDb = dataManager.readAllLokasi();

    if (dataFromDb != null && dataFromDb.size() > 0) {
      view.displayData(dataFromDb);
    } else {
      view.displayNoData();
    }
  }
}
