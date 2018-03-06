package com.lujunwu.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar mToolbar;
    private RecyclerView mRecyclerview;
    public int firstPage = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
       // initDatas(firstPage);

    }

    public void initDatas(View view){
        initDatas(firstPage);
    }

    private void initDatas(int i) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call<Beauty> tenBeauty = retrofit.create(ApiService.class).getTenBeauty(i);
        tenBeauty.enqueue(new Callback<Beauty>() {

            private RecAdapter mRecAdapter;

            @Override
            public void onResponse(Call<Beauty> call, Response<Beauty> response) {
                List<Beauty.ResultsBean> results = response.body().getResults();
                Toast.makeText(MainActivity.this, ""+results.size(), Toast.LENGTH_SHORT).show();
                mRecAdapter = new RecAdapter(MainActivity.this, results);
                mRecyclerview.setAdapter(mRecAdapter);

            }

            @Override
            public void onFailure(Call<Beauty> call, Throwable t) {

            }
        });
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setOnClickListener(this);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(new GridLayoutManager(this,2));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar:
                finish();
                break;
            default:
                break;
        }
    }
}
