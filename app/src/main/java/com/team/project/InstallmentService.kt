package com.team.project

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InstallmentService {
    //TODO: ${}이런 방식으로 바꾸기
    @GET("deposit/deplist")
    fun getInstallmentList(): Call<InstallmentDto>
}