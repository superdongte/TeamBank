package com.team.project

data class BankModel(
    val bankid: String,
    val branchid: String,//이거를 지점으로
    val banklocation:String,
    val banktelephone: String,//이거를 전화번호
    val banklat: Double,
    val banklng: Double,
    val bankimg: String
)