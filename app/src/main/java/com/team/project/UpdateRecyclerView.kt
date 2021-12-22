package com.team.project

import java.util.ArrayList

interface UpdateRecyclerView {
    fun callback(position: Int, items: ArrayList<DynamicRVModel>)
}