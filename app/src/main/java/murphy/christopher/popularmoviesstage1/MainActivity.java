package murphy.christopher.popularmoviesstage1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import murphy.christopher.popularmoviesstage1.adapters.PageAdapter;
import murphy.christopher.popularmoviesstage1.interfaces.TaskDelegate;
import murphy.christopher.popularmoviesstage1.model.Page;
import murphy.christopher.popularmoviesstage1.util.task.MovieTask;

public class MainActivity extends AppCompatActivity {

    //This is my recycler view that I will use for
    //the movie posters
    @BindView(R.id.movie_view)
    RecyclerView mRecyclerView;

    //This is a spinner that I will use to select
    //the movie search types
    @BindView(R.id.search_type)
    Spinner mSearchTypes;

    private PageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupSpinner();
        setupRecyclerView();
    }
    protected void setupSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.search_choices, R.layout.custom_spinner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSearchTypes.setAdapter(adapter);
    }

    //This prevents an error where the layout has no adapter set
    protected void setupRecyclerView(){
        //Create a gridlayout manager and assign it to the recyclerview
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new PageAdapter(new Page());
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnItemSelected(R.id.search_type)
    public void spinnerItemSelected(Spinner spinner, int position) {
        //Create a gridlayout manager and assign it to the recyclerview
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        ConnectivityManager cm = (ConnectivityManager) this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if(activeNetwork != null && activeNetwork.isAvailable() == true
                && activeNetwork.isConnected()){
            //Get the data from themoviedb.org
            new MovieTask(new TaskDelegate() {
                @Override
                public void finishProcess(Page result) {
                    mAdapter = new PageAdapter(result);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }).execute(position);
        }else{
            Toast.makeText(this,R.string.network_error,Toast.LENGTH_LONG);
        }
    }
}
