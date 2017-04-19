package pratamawijaya.com.amikomandroidarchmateri.presentation.ui.lokasi.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pratamawijaya.com.amikomandroidarchmateri.data.DataManager;
import pratamawijaya.com.amikomandroidarchmateri.presentation.ui.lokasi.AddActivityView;

import static org.mockito.Mockito.verify;

/**
 * Created by pratama
 * Date : Apr - 4/19/17
 * Project Name : AmikomAndroidArchMateri
 */
@RunWith(MockitoJUnitRunner.class) public class AddPresenterTest {

  private AddPresenter presenter;

  @Mock DataManager dataManager;
  @Mock AddActivityView view;
  float lat = 0;
  float lng = 0;
  long time = System.currentTimeMillis();

  @Before public void setUp() throws Exception {
    presenter = new AddPresenter(view, dataManager);
  }

  @Test public void test_checkkondisi_nama_kosong() throws Exception {
    //given
    //when
    presenter.saveData("", "desc", lat, lng, time);
    // then
    verify(view).showError("Harap isi data nama lokasi");
  }

  @Test public void test_checkkondisi_desc_kosong() throws Exception {
    //given
    //when
    presenter.saveData("aeuaeu", "", lat, lng, time);
    // then
    verify(view).showError("Harap isi desc lokasi");
  }

  @Test public void test_datalengkap_showsuccess() throws Exception {
    //given
    //when
    presenter.saveData("aeuaeu", "aeuaeu", lat, lng, time);
    // then
    verify(view).addLokasiSukses();
  }
}