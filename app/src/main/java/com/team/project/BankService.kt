package com.team.project

import retrofit2.Call
import retrofit2.http.GET

interface BankService {
    //Todo:이부분만 하면 됨
    @GET("bank/banklist")
    fun getBankList(): Call<BankDto>
}