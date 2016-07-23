package com.codepath.flickster.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.codepath.flickster.R;

/**
 * Created by santoshag on 7/22/16.
 */
public class PopularMovieViewHolder extends RecyclerView.ViewHolder {
    // Your holder should contain a member variable
    // for any view that will be set as you render a row
    private ImageView ivMovieImage;

    public ImageView getIvMovieImage() {
        return ivMovieImage;
    }

    public void setIvMovieImage(ImageView ivMovieImage) {
        this.ivMovieImage = ivMovieImage;
    }


    // We also create a constructor that accepts the entire item row
    // and does the view lookups to find each subview
    public PopularMovieViewHolder(View itemView) {
        // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        super(itemView);
        ivMovieImage = (ImageView) itemView.findViewById(R.id.ivMovieImage);

    }
}
