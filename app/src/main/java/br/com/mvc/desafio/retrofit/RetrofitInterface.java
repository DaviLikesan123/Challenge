package br.com.mvc.desafio.retrofit;

import java.util.List;
import java.util.Map;

import br.com.mvc.desafio.model.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {

    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @PUT("posts/{id}")
    Call<Post> putPost (@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> delete(@Path("id")int id);
}


