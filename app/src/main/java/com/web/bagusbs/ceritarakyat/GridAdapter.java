package com.web.bagusbs.ceritarakyat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private ArrayList<Legend> arara ;
    private OnClickGrid onClickGrid;
    private Context context;

    public void setOnClickGrid(OnClickGrid onClickGrid) {
        this.onClickGrid = onClickGrid;
    }

    public GridAdapter(ArrayList<Legend> arara, Context context ) {
        this.arara = arara;
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_leg, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder gridViewHolder, int position) {
        Legend legend = arara.get(position);

        int resID = context.getResources().getIdentifier( legend.getPhoto(),"drawable", context.getPackageName());
        gridViewHolder.imgPhoto.setImageResource(resID);
        gridViewHolder.tv_Title.setText(legend.getTitle());

        gridViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGrid.onClickGrid(arara.get(gridViewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arara.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;
        public TextView tv_Title;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.iv_grid);
            tv_Title = itemView.findViewById(R.id.tv_ttle);

        }
    }

    public interface OnClickGrid{
        void onClickGrid (Legend data);
    }

}
