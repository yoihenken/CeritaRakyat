package com.web.bagusbs.ceritarakyat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{
    private ArrayList<Legend> arara;
    private Context context;
    private OnClickMove onClickMove;

    public void setOnClickMove(OnClickMove onClickMove) {
        this.onClickMove = onClickMove;
    }

    public CardAdapter(ArrayList<Legend> arara, Context context) {
        this.arara = arara;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_leg, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder cardViewHolder, int position) {
        Legend legend = arara.get(position);

        int resID = context.getResources().getIdentifier(legend.getPhoto(),"drawable", context.getPackageName());
        cardViewHolder.imgPhoto.setImageResource(resID);
        cardViewHolder.tv_Title.setText(legend.getTitle());
        cardViewHolder.tv_From.setText(legend.getFrom());

        cardViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickMove.onClickMove(arara.get(cardViewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arara.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;
        public TextView tv_Title;
        public TextView tv_From;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.iv_card);
            tv_Title = itemView.findViewById(R.id.tv_title);
            tv_From = itemView.findViewById(R.id.tv_from);
        }
    }
    public interface OnClickMove{
        void onClickMove(Legend data);
    }
}
