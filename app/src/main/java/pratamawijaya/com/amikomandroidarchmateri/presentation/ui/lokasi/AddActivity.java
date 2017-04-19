package pratamawijaya.com.amikomandroidarchmateri.presentation.ui.lokasi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import pratamawijaya.com.amikomandroidarchmateri.R;
import pratamawijaya.com.amikomandroidarchmateri.data.DataManager;
import pratamawijaya.com.amikomandroidarchmateri.presentation.pojo.Lokasi;
import pratamawijaya.com.amikomandroidarchmateri.presentation.ui.lokasi.presenter.AddPresenter;

public class AddActivity extends AppCompatActivity
    implements OnMapReadyCallback, GoogleMap.OnCameraMoveListener, AddActivityView {

  @BindView(R.id.etNama) EditText nama;
  @BindView(R.id.etDesc) EditText desc;
  @BindView(R.id.tvLat) TextView tvLat;
  @BindView(R.id.tvLng) TextView tvLng;

  private GoogleMap mMap;
  private float lat;
  private float lng;
  private DataManager dataManager;

  private AddPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add);
    ButterKnife.bind(this);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    dataManager = new DataManager();
    presenter = new AddPresenter(this, dataManager);

    SupportMapFragment mapFragment =
        (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
  }

  @OnClick(R.id.btnSimpan) void onSimpanClick() {

    Lokasi lokasi = new Lokasi.Builder().name(nama.getText().toString())
        .deskripsi(desc.getText().toString())
        .lat(lat)
        .lng(lng)
        .timestamp(System.currentTimeMillis())
        .build();

    //presenter.saveLokasi(nama.get);
  }

  @Override public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    // Add a marker in Sydney and move the camera
    LatLng tugujogja = new LatLng(-7.782884, 110.3648875);
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tugujogja, 14));
    mMap.setOnCameraMoveListener(this);

    lat = (float) mMap.getCameraPosition().target.latitude;
    lng = (float) mMap.getCameraPosition().target.longitude;
  }

  @Override public void onCameraMove() {
    if (mMap != null) {
      tvLat.setText("" + mMap.getCameraPosition().target.latitude + ",");
      tvLng.setText("" + mMap.getCameraPosition().target.longitude);

      lat = (float) mMap.getCameraPosition().target.latitude;
      lng = (float) mMap.getCameraPosition().target.longitude;
    }
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }

  @Override public void addLokasiSukses() {
    Intent returnIntent = new Intent();
    setResult(Activity.RESULT_OK, returnIntent);
    finish();
  }

  @Override public void showError(String message) {
    Toast.makeText(AddActivity.this, message, Toast.LENGTH_SHORT).show();
  }
}
