package com.example.godwingitonga.poliapp.data.remote;

import com.example.godwingitonga.poliapp.data.model.RequestResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by godwingitonga on 01/03/2018.
 */

public interface ApiService {
    @POST("/requests")
    @FormUrlEncoded
    Call<RequestResponse> fetchProvider(@Field("latitude") double latitude,
                                        @Field("longitude") double longitude,
                                        @Field("type") String type);
}
