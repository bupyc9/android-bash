package ru.bupyc9.bashim.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.bupyc9.bashim.models.Post;

public interface UmoriliService {
    @GET("/api/get")
    Call<List<Post>> getData(
        @Query("name") String resourceName,
        @Query("num") int count
    );
}
