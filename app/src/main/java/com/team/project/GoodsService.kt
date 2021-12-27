package com.team.project

import retrofit2.Call
import retrofit2.http.GET

interface GoodsService {
    //TODO: ${}이런 방식으로 바꾸기
    @GET("v3/0622a827-c29d-4f89-83d5-3f2f05e8bf20")
    fun getGoodsList() : Call<GoodsDto>


}