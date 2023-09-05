package br.com.mvc.desafio.view;

import static br.com.mvc.desafio.BuildConfig.BASE_URL;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import br.com.mvc.desafio.R;
import br.com.mvc.desafio.model.Post;
import br.com.mvc.desafio.retrofit.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    public ListView listViewData;

    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDatabase();


//        textViewResult = findViewById(R.id.text_view_result);
        listViewData = findViewById(R.id.listViewData);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Call<List<Post>> call = retrofitInterface.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code:" + response.code());
                }
                List<Post> posts = response.body();

                for (Post post : posts) {
                    String id = String.valueOf(post.getId());
                    String userId = String.valueOf(post.getUserId());
                    String title = post.getTitle() ;
                    String text = post.getText() ;
                    insertDataFromApi(id, userId, title,text);

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
        listData();
    }



    private void createDatabase() {
        try {
            database = openOrCreateDatabase("crudapp", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS " +
                    "Post(" +
                    " userId INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ",id INTEGER" +
                    ",title VARCHAR"+
                    ",text VARCHAR)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listData() {
        try {
            database = openOrCreateDatabase("crudapp", MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT userId, id, title, text from Post ", null);
            ArrayList<String> lines = new ArrayList<>();
            ArrayAdapter myAdapter = new ArrayAdapter<>(
                    this, android.R.layout.activity_list_item, android.R.id.text1, lines
            );
            listViewData.setAdapter(myAdapter);
            cursor.moveToFirst();
            while (cursor != null){
                lines.add(cursor.getString(1));
                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertDataFromApi(String userId, String id, String title, String text) {

        try {
            database = openOrCreateDatabase("crudapp", MODE_PRIVATE, null);
            String sql = "INSERT INTO Post (userId, id, title, text)" + "VALUES (?, ?, ?, ?)";
            SQLiteStatement stmt = database.compileStatement(sql);

            stmt.bindString(1, userId);
            stmt.bindString(2, id);
            stmt.bindString(3, title);
            stmt.bindString(4, text);
            stmt.executeInsert();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}