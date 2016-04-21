package com.example.yawen_li.retrofit20_demo;

import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * Created by Yawen_Li on 2016/4/21.
 */
public class GetBaiduClient {

    public static GetBaiduInterface getBaiduInterface() {
        //在这里定义retrofit对象，一会接口要通过retrofit对象来创建
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                .build();
        // 接口对象由retrofit对象创建而来
        GetBaiduInterface getBaiduInterface = retrofit.create(GetBaiduInterface.class);
        return getBaiduInterface;
    }

    public interface GetBaiduInterface {
        //这里定义的方法都是一些将要与服务器进行交互的方法，在这里我只定义了一个get方法。大家可以自己多试试别的方法。
        @GET("http://www.baidu.com/")
        Call<ResponseBody> get();
    }


}
