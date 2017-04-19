package pratamawijaya.com.amikomandroidarchmateri;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getName();
  public static final int RC_ADD_DATA = 1;
  @BindView(R.id.swipeRefresh) SwipeRefreshLayout swipeRefreshLayout;
  @BindView(R.id.rvContent) RecyclerView rvContent;
  @BindView(R.id.tvNoData) TextView textViewNoData;

  private MainAdapter adapter;
  private List<Lokasi> lokasiList;
  private DataManager dataManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    Log.d(TAG, "onCreate: ");

    dataManager = new DataManager();

    setupRecyclerView();
  }

  @Override protected void onStart() {
    super.onStart();
    Log.d(TAG, "onStart: ");
  }

  @Override protected void onStop() {
    super.onStop();
    Log.d(TAG, "onStop: ");
  }

  @Override protected void onResume() {
    super.onResume();
    Log.d(TAG, "onResume: ");

    ambilData();
  }

  private void ambilData() {
    Log.d(TAG, "ambilData: ");
    List<Lokasi> dataFromDb = dataManager.readAllLokasi();
    if (dataFromDb != null && dataFromDb.size() > 0) {
      if (lokasiList.size() > 0) lokasiList.clear();

      swipeRefreshLayout.setVisibility(View.VISIBLE);
      textViewNoData.setVisibility(View.GONE);

      lokasiList.addAll(dataFromDb);
      adapter.notifyDataSetChanged();
    } else {
      swipeRefreshLayout.setVisibility(View.GONE);
      textViewNoData.setVisibility(View.VISIBLE);
    }
  }

  private void setupRecyclerView() {
    lokasiList = new ArrayList<>();
    adapter = new MainAdapter(this, lokasiList);
    rvContent.setLayoutManager(new LinearLayoutManager(this));
    rvContent.setAdapter(adapter);
  }

  @OnClick(R.id.fabAdd) void onFabClick() {
    startActivityForResult(new Intent(this, AddActivity.class), RC_ADD_DATA);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }
}
