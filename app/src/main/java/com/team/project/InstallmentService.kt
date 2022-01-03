package com.team.project

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InstallmentService {
    //TODO: ${}이런 방식으로 바꾸기
    @GET("v3/09028eb5-c707-4031-b60d-3b53fce7afda")
    fun getInstallmentList(): Call<InstallmentDto>
}