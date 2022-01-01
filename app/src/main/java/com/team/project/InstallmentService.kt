package com.team.project

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InstallmentService {
    //TODO: ${}이런 방식으로 바꾸기
    @GET("v3/8e8a3c32-2f30-4f02-83e2-084e845bada6")
    fun getInstallmentList(): Call<InstallmentDto>
}