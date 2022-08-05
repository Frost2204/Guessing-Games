package com.wall.gussinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class StartPage extends AppCompatActivity {
    MediaPlayer mysong;
    MediaPlayer play;

    @Override
    public void onBackPressed() {
//        mysong.pause();
        Toast.makeText(StartPage.this, "Thanks For Playing!!!", Toast.LENGTH_SHORT).show();
        System.exit(0);
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        play = MediaPlayer.create(StartPage.this,R.raw.play);
        mysong = MediaPlayer.create(StartPage.this,R.raw.bgmusic);
        mysong.start();
    }

    public void openActivity(View view) {
        play.start();
        Toast.makeText(this, "Enjoy", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}