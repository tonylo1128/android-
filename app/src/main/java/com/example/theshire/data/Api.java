package com.example.theshire.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://simplifiedcoding.net/demos/";
    String TARGET_URL = "https://www.lcsd.gov.hk/";
    @GET("/datagovhk/facility/facility-fw.json")
    Call<List<ApiDataModel>> getRouteData();
}