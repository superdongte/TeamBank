package com.team.Project

import java.util.ArrayList

interface UpdateRecyclerView {
    fun callback(position: Int, items: ArrayList<DynamicRVModel>)
}