package murphy.christopher.popularmoviesstage1.util.task;

import android.os.AsyncTask;


import java.io.IOException;

import murphy.christopher.popularmoviesstage1.BuildConfig;
import murphy.christopher.popularmoviesstage1.interfaces.GetMovieDataService;
import murphy.christopher.popularmoviesstage1.interfaces.TaskDelegate;
import murphy.christopher.popularmoviesstage1.model.Page;
import murphy.christopher.popularmoviesstage1.util.Constants;
import murphy.christopher.popularmoviesstage1.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieTask extends AsyncTask<Integer, Void, Page>{

    private String movieSearch;
    private Retrofit retrofitInstance;
    private GetMovieDataService service;
    private TaskDelegate delegate;
    public MovieTask(TaskDelegate d){

        //Get a retrofit instance for this task
        retrofitInstance = RetrofitUtil.getRetrofitInstance();

        //Create the service to get the movie data
        service = retrofitInstance.create(GetMovieDataService.class);

        this.delegate = d;
    }

    @Override
    //Send a single parameter for the movie search type
    protected Page doInBackground(Integer... movieSearch) {

        Call<Page> page_call = null;
        Response<Page> page_response = null;
        Page page = null;

        switch(movieSearch[0]){
           case Constants.TOP_RATED:
                page_call = service.getTopRatedMovies(BuildConfig.MOVIE_DB_API_KEY);
                break;
           case Constants.POPULAR_MOVIES:
                page_call = service.getPopularMovies(BuildConfig.MOVIE_DB_API_KEY);
                break;
            default:
                //do something here because there is an error
        }

        try {
            page_response = page_call.execute();
            page = page_response.body();
        } catch (IOException e) {
            e.printStackTrace();
            //print a message to the user
        }

        return page;
    }

    @Override
    protected void onPostExecute(Page page) {
        if(page != null){
            delegate.finishProcess(page);
        }
    }
}
