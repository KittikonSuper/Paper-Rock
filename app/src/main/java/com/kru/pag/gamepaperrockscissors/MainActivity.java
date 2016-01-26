package com.kru.pag.gamepaperrockscissors;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        //Paper Controller
        paperController();
        //Rock Controller
        rockController();
        //ScissorController
        scissorController();
    }// Main Metthod

    private void scissorController() {
        scissorImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlay(3);
            }
        });
    }

    private void rockController() {
        rockImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changePlay(2);
            }
        });
    }

    private void paperController() {

        paperImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intNumber = 1;
                changePlay(intNumber);

            }
        });

    } // paperController

    private void changePlay(int intNumber) {

        Log.d("test","ค่าที่รับได้ = " + intNumber);
        int intSound = R.raw.mosquito;
        switch (intNumber) {
            case 1:
                playImageViwe.setImageResource(R.drawable.paper);
                intSound = R.raw.k2;
                break;
            case 2:
                playImageViwe.setImageResource(R.drawable.rock);
                intSound = R.raw.k1;
                break;
            case 3:
                playImageViwe.setImageResource(R.drawable.scissors);
                intSound = R.raw.k3;
                break;
        }// switch
        MediaPlayer imageMediaPlayer = MediaPlayer.create(getBaseContext(), intSound);
        imageMediaPlayer.start();
    }// changePlay



    private void bindwidget() {
        paperImageView = (ImageView) findViewById(R.id.imvPaper);
        rockImageView = (ImageView) findViewById(R.id.imvRock);
        scissorImageView = (ImageView) findViewById(R.id.imvScissors);
        playImageViwe = (ImageView) findViewById(R.id.imvPlayer);
        androidImageView = (ImageView) findViewById(R.id.imvAndroid);
        showtextView = (TextView) findViewById(R.id.txtShow);


    }
} // Main Class นี่คือคลาสหลักก
