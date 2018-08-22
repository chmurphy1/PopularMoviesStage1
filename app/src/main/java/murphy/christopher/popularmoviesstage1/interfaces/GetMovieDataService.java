package murphy.christopher.popularmoviesstage1.interfaces;

import murphy.christopher.popularmoviesstage1.model.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovieDataService{

    //This will get a single page worth of results
    //for popular movies
    @GET("/3/movie/popular")
    Call<Page> getPopularMovies(@Query(value="api_key") String key);

    //This will get a single page worth of results
    //for top movies
    @GET("/3/movie/top_rated")
    Call<Page> getTopRatedMovies(@Query(value="api_key") String key);
}