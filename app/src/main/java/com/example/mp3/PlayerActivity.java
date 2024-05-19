package com.example.mp3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private TextView songTitleTextView;
    private TextView artistNameTextView;
    private ImageView albumArtImageView;
    private int songFile;
    private int songImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // Initialize views
        songTitleTextView = findViewById(R.id.songTitle);
        artistNameTextView = findViewById(R.id.songArtist);
        albumArtImageView = findViewById(R.id.albumArt);

        // Get data from Intent
        String songTitle = getIntent().getStringExtra("songTitle");
        String artistName = getIntent().getStringExtra("songArtist");
        songFile = getIntent().getIntExtra("songFile", 0);
        songImageId = getIntent().getIntExtra("songImage", R.drawable.lemon);

        // Set song details
        songTitleTextView.setText(songTitle);
        artistNameTextView.setText(artistName);
        albumArtImageView.setImageResource(songImageId);

        // Start playing the song
        startPlayingSong();
    }

    private void startPlayingSong() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(this, songFile);
        mediaPlayer.start();
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
