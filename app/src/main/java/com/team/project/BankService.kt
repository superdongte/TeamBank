package com.team.project

import retrofit2.Call
import retrofit2.http.GET

interface BankService {
    //이부분만 하면 됨
    @GET("v3/78fb0ca2-01de-4a97-869d-0cd6bafb010d")
    fun getBankList(): Call<BankDto>
}