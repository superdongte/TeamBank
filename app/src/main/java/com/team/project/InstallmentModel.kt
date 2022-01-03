package com.team.project

data class InstallmentModel(
    val depositid: Int,
    val baserate: Double,
    val dmonth: Int,
    val depositname: String,
    val primerate: Double,
    val bankname: String,
    val dkind: String,
    var itemPrice: Int
)
