package murphy.christopher.popularmoviesstage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import java.nio.file.spi.FileTypeDetector;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import murphy.christopher.popularmoviesstage1.model.Movie;
import murphy.christopher.popularmoviesstage1.util.Constants;

public class MovieDetailActivity extends AppCompatActivity {

    private Movie movieDetails;

    @BindView(R.id.movieDetailPoster)
    ImageView detailPoster;

    @BindView(R.id.rating)
    TextView rating;

    @BindView(R.id.release_date)
    TextView releaseDate;

    @BindView(R.id.synopsis)
    TextView synopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);

        Intent intent = getIntent();
        movieDetails = Parcels.unwrap(intent.getParcelableExtra("movie"));

        if(movieDetails == null){
            //display message to user
        }
        //Set the title of the activity screen
        this.setTitle(movieDetails.getOriginal_title());

        ButterKnife.bind(this);

        Glide.with(this)
                .load(Constants.MOVIE_URL_W185 + movieDetails.getPoster_path())
                .into(detailPoster);

        rating.setText(movieDetails.getVote_average()+"");
        releaseDate.setText( sdf.format(movieDetails.getRelease_date()));
        synopsis.setText(movieDetails.getOverview());
    }
}
