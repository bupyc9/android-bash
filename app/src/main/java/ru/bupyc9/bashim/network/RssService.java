package ru.bupyc9.bashim.network;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.bupyc9.bashim.models.Feed;

public interface RssService {
    @GET("/tema/igryi/feed/")
    Call<Feed> getGameNews();
}
