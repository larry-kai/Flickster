package com.codepath.flickster.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flickster.R;
import com.codepath.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by santoshag on 7/19/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    private static final String TAG = "MovieArrayAdapter";

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the movie data for the position
        Movie movie = getItem(position);

        //check if existing view is being reused
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
             convertView = layoutInflater.inflate(R.layout.item_movie, parent, false);
        }

        //find the movie image view
        ImageView ivMovieImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        //clear out image from image view
        ivMovieImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        Log.i(TAG, "movie poster path: " + movie.getPosterPath());
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivMovieImage);
        return  convertView;

    }
}
