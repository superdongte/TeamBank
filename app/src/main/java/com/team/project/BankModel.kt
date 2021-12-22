package com.team.project

data class BankModel(
    val id: Int,
    val name: String,//이거를 지점으로
    val telephonenum: String,//이거를 전화번호
    val lat: Double,
    val lng: Double,
    val imgUrl: String
)