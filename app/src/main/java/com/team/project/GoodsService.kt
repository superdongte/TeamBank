package com.team.project

import android.content.Intent
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GoodsService {
    //TODO: ${}이런 방식으로 바꾸기
    @GET("item/view/{temp}")
    open fun getGoodsList(@Path("temp") temp: String?): Call<GoodsDto>
}