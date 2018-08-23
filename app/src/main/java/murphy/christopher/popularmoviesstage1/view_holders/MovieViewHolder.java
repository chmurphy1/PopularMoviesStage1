package murphy.christopher.popularmoviesstage1.view_holders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import murphy.christopher.popularmoviesstage1.MainActivity;
import murphy.christopher.popularmoviesstage1.MovieDetailActivity;
import murphy.christopher.popularmoviesstage1.R;
import murphy.christopher.popularmoviesstage1.model.Movie;
import murphy.christopher.popularmoviesstage1.util.Constants;

import static android.support.v4.content.ContextCompat.startActivity;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.movie)
    ImageView imgMovie;

    private Movie movie;
    private Context context;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        ButterKnife.bind(this, itemView);

    }
    public void bind(Movie movie){
        this.movie = movie;

        Glide.with(context)
                .load(Constants.MOVIE_URL_W185 + movie.getPoster_path())
                .into(imgMovie);
    }
    @OnClick(R.id.movie)
    public void onMovieClick(){
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra("movie", Parcels.wrap(movie));
        context.startActivity(intent);
    }
}
