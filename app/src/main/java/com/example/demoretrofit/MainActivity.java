package com.example.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
        ProgressDialog progressDialog;
    RecyclerView recyclerView;
    List<model> imagesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


       // imagesList=new ArrayList<>();

showdata();


    }

    public void showdata()

    {
        progressDialog=new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.show();
        myapi webService=myapi.retrofit.create(myapi.class);
        Call<List<model>> call=webService.getPosts();
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                if(response.isSuccessful() &&response.body()!=null)
                {
                    progressDialog.dismiss();
                        for(int i=0;i<response.body().size();i++)
                        {
                            Toast.makeText(getApplicationContext(), ""+response.body().get(i).getCourseName(), Toast.LENGTH_SHORT).show();
                        }

                    List<model> data=response.body();
                    adapter_recyclerview myadaptr=new adapter_recyclerview(data);
                    recyclerView.setAdapter(myadaptr);




                }
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
            }
        });


    }

}
