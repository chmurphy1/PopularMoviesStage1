package murphy.christopher.popularmoviesstage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class MainActivity extends AppCompatActivity {
    //This is my recycler view that I will use for
    //the movie posters
    @BindView(R.id.movie_view)
    RecyclerView mRecyclerView;

    //This is a spinner that I will use to select
    //the movie search types
    @BindView(R.id.search_type)
    Spinner mSearchTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupSpinner();
    }
    protected void setupSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.search_choices, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSearchTypes.setAdapter(adapter);
    }
    @OnItemSelected(R.id.search_type)
    public void spinnerItemSelected(Spinner spinner, int position) {

    }
}
