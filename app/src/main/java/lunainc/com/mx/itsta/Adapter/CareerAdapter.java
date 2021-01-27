package lunainc.com.mx.itsta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lunainc.com.mx.itsta.Model.Career;
import lunainc.com.mx.itsta.R;

public class CareerAdapter extends RecyclerView.Adapter<CareerAdapter.CareerViewHolder> {

    private ItemClickListener mClickListener;
    private List<Career> careers;
    private Context context;
    private LayoutInflater mInflater;

    public CareerAdapter(Context context, List<Career> careers) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.careers = careers;

    }


    @NonNull
    @Override
    public CareerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);

        return new CareerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CareerViewHolder holder, int position) {
        Career item = careers.get(position);


        Glide.with(context).load(context.getDrawable(item.getImageBanner())).into(holder.image);

        holder.name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return careers.size();
    }


    public class CareerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.image)
        ImageView image;


        CareerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }

        }

    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
