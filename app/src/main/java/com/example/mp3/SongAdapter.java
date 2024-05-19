package com.example.mp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SongAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] songs;
    private String[] artists;
    private int[] images;

    public SongAdapter(Context context, String[] songs, String[] artists, int[] images) {
        super(context, R.layout.list_item, songs);
        this.context = context;
        this.songs = songs;
        this.artists = artists;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.songTitle = rowView.findViewById(R.id.song_title);
            holder.artistName = rowView.findViewById(R.id.artist_name);
            holder.albumArt = rowView.findViewById(R.id.album_art);

            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        holder.songTitle.setText(songs[position]);
        holder.artistName.setText(artists[position]);
        holder.albumArt.setImageResource(images[position]);

        return rowView;
    }

    static class ViewHolder {
        TextView songTitle;
        TextView artistName;
        ImageView albumArt;
    }
}
