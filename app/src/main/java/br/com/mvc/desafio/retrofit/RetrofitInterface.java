package br.com.mvc.desafio.retrofit;

import java.util.List;

import br.com.mvc.desafio.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("posts")
    Call<List<Post>> getPosts();
//
//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//
//    RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
//
//        static RetrofitInterface getInstance() {
//            return retrofitInterface;
//        }

}


