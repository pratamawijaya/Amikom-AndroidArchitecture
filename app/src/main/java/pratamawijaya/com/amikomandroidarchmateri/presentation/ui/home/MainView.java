package pratamawijaya.com.amikomandroidarchmateri.presentation.ui.home;

import java.util.List;
import pratamawijaya.com.amikomandroidarchmateri.presentation.pojo.Lokasi;

/**
 * Created by pratama
 * Date : Apr - 4/19/17
 * Project Name : AmikomAndroidArchMateri
 */

public interface MainView {
  void displayData(List<Lokasi> dataFromDb);

  void displayNoData();
}
