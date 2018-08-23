package murphy.christopher.popularmoviesstage1.view_holders;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import murphy.christopher.popularmoviesstage1.R;
import murphy.christopher.popularmoviesstage1.model.Movie;
import murphy.christopher.popularmoviesstage1.util.Constants;

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
}
