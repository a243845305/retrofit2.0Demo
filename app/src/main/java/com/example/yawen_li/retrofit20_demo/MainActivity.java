package com.example.yawen_li.retrofit20_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //在需要的地方拿到接口对象，service就是一个接口对象
        GetBaiduClient.GetBaiduInterface service = GetBaiduClient.getBaiduInterface();
        //Call<T>就是一个回调方法，获取到Call，我们才能执行请求
        Call<ResponseBody> call = service.get();
        //使用异步方式执行请求，关于同步异步可以在网上找一些博客
        call.enqueue(new Callback<ResponseBody>() {//异步请求
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    //并没有使用Gson，只是获取一下请求，尝试一下retrofit怎么用，所以就直接Log输出了
                    String body = response.body().string();//获取返回体的字符串
                    Log.e("MainActivity", body);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("MainActivity", "onFailure");
            }
        });
    }
}
