package com.example.mp3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView playlistView;
    private MediaPlayer mediaPlayer;
    private String[] songs = {"Lemon", "Lady", "さよーならまたいつか！"};
    private String[] artists = {"요네즈 켄시", "Kenshi Yonezu", "米津玄師"};
    private int[] songFiles = {R.raw.lemon, R.raw.lady, R.raw.sayonara};
    private int[] songImages = {R.drawable.lemon, R.drawable.lady, R.drawable.sayonara};
    private int currentSongIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playlistView = findViewById(R.id.playlistView);
        SongAdapter adapter = new SongAdapter(this, songs, artists, songImages);
        playlistView.setAdapter(adapter);

        playlistView.setOnItemClickListener((parent, view, position, id) -> {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            mediaPlayer = MediaPlayer.create(MainActivity.this, songFiles[position]);
            mediaPlayer.start();
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
