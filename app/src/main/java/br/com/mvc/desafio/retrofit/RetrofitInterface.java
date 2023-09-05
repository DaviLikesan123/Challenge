package br.com.mvc.desafio.retrofit;

import java.util.List;

import br.com.mvc.desafio.model.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST
    Call<Post> createPost(@Body Post post);

}


