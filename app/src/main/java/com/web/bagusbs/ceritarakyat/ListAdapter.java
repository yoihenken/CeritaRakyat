package com.web.bagusbs.ceritarakyat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<Legend> arara;

    private OnMove onMove;
    public void setOnMove(OnMove onMove) {
        this.onMove = onMove;
    }

    public ListAdapter(ArrayList<Legend> list) {
        this.arara = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_leg, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, int position) {
        Legend legend = arara.get(position);

        Glide.with(listViewHolder.itemView.getContext())
                .load(legend.getPhoto())
                .apply(new RequestOptions().override(100,100))
                .into(listViewHolder.imgPhoto);

        listViewHolder.tvTitle.setText(legend.getTitle());
        listViewHolder.tvContent.setText(legend.getContent());

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMove.onMove(arara.get(listViewHolder.getAdapterPosition()));

            }
        });

    }

    public interface OnMove {
        void onMove(Legend data);
    }

    @Override
    public int getItemCount() {
        return arara.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvContent;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.c_photo);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
