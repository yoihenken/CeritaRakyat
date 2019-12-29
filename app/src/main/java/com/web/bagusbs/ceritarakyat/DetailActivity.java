package com.web.bagusbs.ceritarakyat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    private ImageView iv_leg;
    private TextView tv_Title;
    private TextView tv_Content;
    private TextView tv_From;

    public static final String X_Title = "extra_ttl";
    public static final String X_Content = "extra_content";
    public static final String X_Photo = "extra_photo";
    public static final String X_From = "extra_from";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        iv_leg = findViewById(R.id.iv_leg);
        tv_Title = findViewById(R.id.tv_title);
        tv_Content = findViewById(R.id.tv_content);
        tv_From = findViewById(R.id.tv_from);

        String Title = getIntent().getStringExtra(X_Title);
        String Content = getIntent().getStringExtra(X_Content);
        String Photo = getIntent().getStringExtra(X_Photo);
        String From = "Daerah\t:\t" + getIntent().getStringExtra(X_From);
        int resID = getResources().getIdentifier(Photo,"drawable", getPackageName());

        iv_leg.setImageResource(resID);
        tv_Title.setText(Title);
        tv_Content.setText(Content);
        tv_From.setText(From);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(Title);
        }


    }
}
