package br.com.mvc.desafio.controller;

import androidx.appcompat.app.AppCompatActivity;

public class MainController extends AppCompatActivity {

//    private TextView editTextViewResult;
//    private MainRepository mainRepository;
//
//    private final MutableLiveData<List<User>> userList = new MutableLiveData<>();
//    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
//
//    public void getUsers() {
//        Call<List<User>> request = mainRepository.getUsers();
//        request.enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
////                userList.postValue(response.body());
//
//                List<User> users = response.body();
//                for(User user : users) {
//                    String content = "";
//                    content += "Id: " + user.getId() + "\n";
//                    content += "User ID: " + user.getUserId() + "\n";
//                    content += "Title: " + user.getTitle() + "\n";
//                    content += "Text: " + user.getText() + "\n\n";
//
//                    editTextViewResult = findViewById(R.id.text_view_result);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                errorMessage.postValue(t.getMessage());
//            }
//        });
//    }


}
