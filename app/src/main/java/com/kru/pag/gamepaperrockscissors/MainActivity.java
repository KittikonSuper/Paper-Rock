package com.kru.pag.gamepaperrockscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //Explicit
    private ImageView paperImageView, rockImageView,
            scissorImageView, playImageViwe, androidImageView;
    private TextView showtextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind widget
        bindwidget();
    }// Main Metthod

    private void bindwidget() {
        paperImageView = (ImageView) findViewById(R.id.imvPaper);
        rockImageView = (ImageView) findViewById(R.id.imvRock);
        scissorImageView = (ImageView) findViewById(R.id.imvScissors);
        playImageViwe = (ImageView) findViewById(R.id.imvPlayer);
        androidImageView = (ImageView) findViewById(R.id.imvAndroid);
        showtextView = (TextView) findViewById(R.id.txtShow);


    }
} // Main Class นี่คือคลาสหลักก
