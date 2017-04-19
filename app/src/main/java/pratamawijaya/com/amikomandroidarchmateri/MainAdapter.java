package pratamawijaya.com.amikomandroidarchmateri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;

/**
 * Created by pratama
 * Date : Apr - 4/19/17
 * Project Name : AmikomAndroidArchMateri
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

  private Context context;
  private List<Lokasi> lokasiList;

  public MainAdapter(Context context, List<Lokasi> lokasiList) {
    this.context = context;
    this.lokasiList = lokasiList;
  }

  @Override public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MainHolder(
        LayoutInflater.from(context).inflate(R.layout.layout_item_lokasi, parent, false));
  }

  @Override public void onBindViewHolder(MainHolder holder, int position) {
    holder.bindData(lokasiList.get(position));
  }

  @Override public int getItemCount() {
    return lokasiList.size();
  }

  public class MainHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imgThumb) ImageView thumb;
    @BindView(R.id.tvName) TextView tvName;
    @BindView(R.id.tvDesc) TextView tvDesc;

    public MainHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    public void bindData(Lokasi lokasi) {
      tvName.setText("" + lokasi.name);
      tvDesc.setText("" + lokasi.deskripsi);
    }
  }
}
