package com.web.bagusbs.ceritarakyat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rvView;
    private ArrayList<Legend> arara = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvView = findViewById(R.id.rv_leg);
        rvView.setHasFixedSize(true);

        arara.addAll(LegendData.getLegendData());
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Cerita Rakyat");
        }
        showCardLayout();
    }

//    private void showRecycleList() {
//        rvView.setLayoutManager(new LinearLayoutManager(this));
//        ListAdapter listAdapter = new ListAdapter(arara);
//        rvView.setAdapter(listAdapter);
//
//        listAdapter.setOnMove(new ListAdapter.OnMove() {
//            @Override
//            public void onMove(Legend data) {
//                showSelectedHero(data);
//                Intent moveIntent = new Intent(MainActivity.this, DetailActivity.class);
//                moveIntent.putExtra(DetailActivity.X_Title, data.getTitle());
//                moveIntent.putExtra(DetailActivity.X_Content, data.getContent());
//               //moveIntent.putExtra(DetailActivity.X_Photo, data.getPhoto());
//                startActivity(moveIntent);
//            }
//        });
//    }

//    private void showGridLayout(){
//        rvView.setLayoutManager(new GridLayoutManager(this, 3));
//        GridAdapter gridAdapter = new GridAdapter(arara, this);
//        rvView.setAdapter(gridAdapter);
//
//        gridAdapter.setOnClickGrid(new GridAdapter.OnClickGrid() {
//            @Override
//            public void onClickGrid(Legend data) {
//                showSelectedHero(data);
//                Intent moveIntent = new Intent(MainActivity.this, DetailActivity.class);
//                moveIntent.putExtra(DetailActivity.X_Title, data.getTitle());
//                moveIntent.putExtra(DetailActivity.X_Content, data.getContent());
//                moveIntent.putExtra(DetailActivity.X_Photo, data.getPhoto());
//                startActivity(moveIntent);
//            }
//        });
//    }

    private void showCardLayout(){
        rvView.setLayoutManager(new GridLayoutManager(this, 3));
        CardAdapter cardAdapter = new CardAdapter(arara, this);
        rvView.setAdapter(cardAdapter);

        cardAdapter.setOnClickMove(new CardAdapter.OnClickMove() {
            @Override
            public void onClickMove(Legend data) {
                showSelectedHero(data);
                Intent moveIntent = new Intent(MainActivity.this, DetailActivity.class);
                moveIntent.putExtra(DetailActivity.X_Title, data.getTitle());
                moveIntent.putExtra(DetailActivity.X_Content, data.getContent());
                moveIntent.putExtra(DetailActivity.X_Photo, data.getPhoto());
                moveIntent.putExtra(DetailActivity.X_From,data.getFrom());
                startActivity(moveIntent);
            }
        });
    }

    private void showSelectedHero(Legend title) {
        Toast.makeText(this, "Kamu memilih " + title.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}
