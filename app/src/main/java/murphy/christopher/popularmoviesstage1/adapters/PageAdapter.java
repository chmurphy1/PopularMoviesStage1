package murphy.christopher.popularmoviesstage1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import murphy.christopher.popularmoviesstage1.R;
import murphy.christopher.popularmoviesstage1.model.Page;
import murphy.christopher.popularmoviesstage1.view_holders.MovieViewHolder;


public class PageAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private Page mPage;

    public PageAdapter(Page result){
        this.mPage = result;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater mInflater = LayoutInflater.from(context);
        View v = mInflater.inflate(R.layout.images, viewGroup,false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.bind(mPage.getResults().get(i));
    }

    @Override
    public int getItemCount() {
        return mPage.getResults().size();
    }
}
