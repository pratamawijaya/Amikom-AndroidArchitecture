package pratamawijaya.com.amikomandroidarchmateri.presentation.ui.home.presenter;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pratamawijaya.com.amikomandroidarchmateri.data.DataManager;
import pratamawijaya.com.amikomandroidarchmateri.presentation.pojo.Lokasi;
import pratamawijaya.com.amikomandroidarchmateri.presentation.ui.home.MainView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pratama
 * Date : Apr - 4/19/17
 * Project Name : AmikomAndroidArchMateri
 */
@RunWith(MockitoJUnitRunner.class) public class MainPresenterTest {

  private MainPresenter presenter;

  @Mock MainView view;
  @Mock DataManager dataManager;
  @Mock Log log;

  @Before public void setUp() throws Exception {
    presenter = new MainPresenter(view, dataManager);
  }

  @Test public void test_data_kosong_tampilkan_view_kosong() throws Exception {
    //given
    when(dataManager.readAllLokasi()).thenReturn(getLokasiKosong());
    //when
    presenter.getDataLokasi();
    //then
    verify(view).displayNoData();
  }

  @Test public void test_data_ada_tampilkan_data() throws Exception {
    //given
    List<Lokasi> lokasiList = generateDummyData();
    when(dataManager.readAllLokasi()).thenReturn(lokasiList);
    //when
    presenter.getDataLokasi();
    //then
    verify(view).displayData(lokasiList);
  }

  private List<Lokasi> generateDummyData() {
    List<Lokasi> lokasiList = new ArrayList<>();
    lokasiList.add(new Lokasi.Builder().name("Parang tritis").build());
    return lokasiList;
  }

  private List<Lokasi> getLokasiKosong() {
    List<Lokasi> lokasiList = new ArrayList<>();
    return lokasiList;
  }
}