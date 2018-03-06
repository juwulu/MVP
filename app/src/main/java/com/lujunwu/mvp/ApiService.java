package com.lujunwu.mvp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lujunwu on 2018/3/6.
 */

public interface ApiService {
    //http://gank.io/api/data/福利/10/1
    @GET("api/data/福利/20/{page}")
    Call<Beauty> getTenBeauty(@Path("page") int page);

}
