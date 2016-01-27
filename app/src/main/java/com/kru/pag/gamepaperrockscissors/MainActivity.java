package com.kru.pag.gamepaperrockscissors;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //Explicit
    private ImageView paperImageView, rockImageView,
            scissorImageView, playImageViwe, androidImageView;
    private TextView showtextView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }// Main Metthod

    private void scissorController() {
        scissorImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlay(3);
                myRandomPicture(3);
            }
        });
    }

    private void rockController() {
        rockImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changePlay(2);
                myRandomPicture(2);
            }
        });
    }

    private void paperController() {

        paperImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intNumber = 1;
                myRandomPicture(1);
                changePlay(intNumber);


            }
        });

    } // paperController
    private void myRandomPicture(int intUser) {

        int intMyRandom = 0;
        Random objRandom = new Random();
        intMyRandom = objRandom.nextInt(3) + 1;
        Log.d("Ran", "intRandom==>" + intMyRandom);
        androidChange(intMyRandom);

        checkScore(intUser, intMyRandom);

    }//myRandomPicture

    private void checkScore(int intUser, int intMyRandom) {

        String strWin = "ไชโย คุณชนะ";
        String strLost = "เสียใจด้วย คุณแพ้";
        String strDew = "เอาใหม่ คุณเสมอ";
        String strShow = null;
        int[] intSound = new int[3];
        intSound[0] = R.raw.cat;

        //1 ==> กระดาษ, 2 ==> ค้อน , 3 ==> กรรไกร
        switch (intUser) {
            case 1://กระดาษ
                switch (intMyRandom) {
                    case 1:
                        strShow = strDew;
                        break;
                    case 2:
                        strShow = strWin;
                        break;
                    case 3:
                        strShow = strLost;
                        break;
                }
                break;
            case 2://ค้อน
                switch (intMyRandom) {
                    case 1:
                        strShow = strLost;
                        break;
                    case 2:
                        strShow = strDew;
                        break;
                    case 3:
                        strShow = strWin;
                        break;
                }
                break;
            case 3://กรรไกร
                switch (intMyRandom) {
                    case 1:
                        strShow = strLost;
                        break;
                    case 2:
                        strShow = strDew;
                        break;
                    case 3:
                        strShow = strWin;
                        break;
                }
                break;
        }//switch
        showtextView.setText(strShow);
    }//checkScore

    private void androidChange(int intMyRandom) {
        int[] intSourceImage = new int[4];
        intSourceImage[0] = 0;
        intSourceImage[1] = R.drawable.paper;
        intSourceImage[2] = R.drawable.rock;
        intSourceImage[3] = R.drawable.scissors;

        androidImageView.setImageResource(intSourceImage[intMyRandom]);
    }//androidChange

    private void changePlay(int intNumber) {

        Log.d("test", "ค่าที่รับได้ = " + intNumber);
        int intSound = R.raw.mosquito;
        switch (intNumber) {
            case 1:
                playImageViwe.setImageResource(R.drawable.paper);
                intSound = R.raw.mosquito;
                break;
            case 2:
                playImageViwe.setImageResource(R.drawable.rock);
                intSound = R.raw.cat;
                break;
            case 3:
                playImageViwe.setImageResource(R.drawable.scissors);
                intSound = R.raw.elephant;
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.kru.pag.gamepaperrockscissors/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.kru.pag.gamepaperrockscissors/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
} // Main Class นี่คือคลาสหลักก
