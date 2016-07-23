package com.codepath.flickster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flickster.R;
import com.codepath.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by santoshag on 7/19/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private static final String TAG = "MovieArrayAdapter";
    // Store a member variable for the movies
    private List<Movie> mMovies;
    // Store the context for easy access
    private Context mContext;

    // Easy access to the context object in the recyclerview
    public Context getContext() {
        return mContext;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvTitle;
        public TextView tvOverview;
        public ImageView ivMovieImage;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvOverview = (TextView) itemView.findViewById(R.id.tvOverview);
            ivMovieImage = (ImageView) itemView.findViewById(R.id.ivMovieImage);

        }
    }

    // Pass in the movie list into the constructor
    public MovieAdapter(Context context, List<Movie> movies){
        mMovies = movies;
        mContext = context;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View movieView = inflater.inflate(R.layout.item_movie, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(movieView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Movie movie = mMovies.get(position);

        // Set item views based on your views and data model
        TextView tvTitle = viewHolder.tvTitle;
        tvTitle.setText(movie.getOriginalTitle());
        TextView tvOverview = viewHolder.tvOverview;
        tvOverview.setText(movie.getOverview());

        String imagePath = new String();
        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            imagePath = movie.getPosterPath();

        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            imagePath = movie.getBackdropPath();
        }

        ImageView ivMovieImage = viewHolder.ivMovieImage;
        Picasso.with(getContext()).load(imagePath).placeholder(R.mipmap.ic_launcher).transform(new RoundedCornersTransformation(15, 15, RoundedCornersTransformation.CornerType.BOTTOM_RIGHT)).into(ivMovieImage);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}