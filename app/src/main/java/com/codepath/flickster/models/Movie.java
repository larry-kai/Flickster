package com.codepath.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by santoshag on 7/19/16.
 */
public class Movie {

    String posterPath;
    String originalTitle;
    String overview;
    String backdropPath;
    Double vote_average;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w500/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w1280/%s", backdropPath);
    }

    public Double getVoteAverage() {
        return vote_average;
    }

    public Boolean isPopularMovie() {
        if(vote_average < 5.0)
            return false;
        return true;
    }



    public Movie(JSONObject jsonObject) throws JSONException {

        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.vote_average = jsonObject.getDouble("vote_average");

    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for(int x = 0; x < array.length(); x++){
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }
}
