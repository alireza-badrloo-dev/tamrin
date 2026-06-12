package com.example.myapplication6;



import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    Handler handler;
    Runnable runnable;

    Boolean isplaying = false;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, int deviceId) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId);
        if (requestCode == 100){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                ReadMusic();
            }else {
                Toast.makeText(this,"permission is not granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);




        String permission;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            permission = Manifest.permission.READ_MEDIA_AUDIO;
        }else {
            permission = Manifest.permission.READ_EXTERNAL_STORAGE;
        }

        if (ContextCompat.checkSelfPermission(this,permission) == PackageManager.PERMISSION_GRANTED){
            ReadMusic();
        }else {
            ActivityCompat.requestPermissions(this,new String[]{permission},100);
        }


    }
    public MediaPlayer mediaPlayer;
    public void ReadMusic() {
        ImageView btn_item = findViewById(R.id.btn_item);
        if (getIntent().getData() != null) {
            Uri uri = getIntent().getData();
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(this, uri);
                mediaPlayer.prepare();
                mediaPlayer.start();
                btn_item.setImageResource(R.drawable.pause);
                SeekBar prg = findViewById(R.id.seekbar);
                prg.setMax(mediaPlayer.getDuration());
                prg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mediaPlayer.seekTo(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        prg.setProgress(mediaPlayer.getCurrentPosition());
                        handler.postDelayed(runnable, 1000);
                    }
                };


                btn_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isplaying == false) {
                            mediaPlayer.start();
                            isplaying = true;
                            btn_item.setImageResource(R.drawable.pause);
                            handler.post(runnable);
                        } else {
                            mediaPlayer.pause();
                            isplaying = false;
                            btn_item.setImageResource(R.drawable.play);
                        }
                    }
                });
                handler.post(runnable);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}