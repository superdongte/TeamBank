package com.team.project

import retrofit2.Call
import retrofit2.http.GET

interface GoodsService {
    //TODO: ${}이런 방식으로 바꾸기
    @GET("item/view/F01")
    fun getGoodsList() : Call<GoodsDto>


}