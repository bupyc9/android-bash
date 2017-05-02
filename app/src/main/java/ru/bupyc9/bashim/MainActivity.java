package ru.bupyc9.bashim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.bupyc9.bashim.adapters.FeedListAdapter;
import ru.bupyc9.bashim.adapters.PostListAdapter;
import ru.bupyc9.bashim.models.Feed;
import ru.bupyc9.bashim.models.FeedItem;
import ru.bupyc9.bashim.models.Post;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
            mRecyclerView.getContext(),
            layoutManager.getOrientation()
        );

        mRecyclerView.addItemDecoration(dividerItemDecoration);

        json();
//        xml();
    }

    private void json() {
        final List<Post> items = new ArrayList<>();
        mRecyclerView.setAdapter(new PostListAdapter(items));

        App.getUmoriliApi().getData("bash", 5).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                items.addAll(response.body());
                mRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void xml() {
        final List<FeedItem> items = new ArrayList<>();
        mRecyclerView.setAdapter(new FeedListAdapter(items));

        App.getRssApi().getGameNews().enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                items.addAll(response.body().getChannel().getFeedItems());
                mRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.d("Main", "error", t);
                Toast.makeText(MainActivity.this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
