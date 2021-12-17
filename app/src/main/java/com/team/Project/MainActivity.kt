package com.team.Project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity(), UpdateRecyclerView {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var staticRvAdapter: StaticRvAdapter
    lateinit var items: ArrayList<DynamicRVModel>
    lateinit var dynamicRVAdapter: DynamicRVAdapter
    var pos = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ) //전체화면을 위한 코드
        setContentView(R.layout.activity_main)
        val item = ArrayList<StaticRvModel>()
        item.add(StaticRvModel(R.drawable.burger, "burger"))
        item.add(StaticRvModel(R.drawable.pizza, "pizza"))
        item.add(StaticRvModel(R.drawable.fries, "fries"))
        item.add(StaticRvModel(R.drawable.sandwich, "sandwich"))
        item.add(StaticRvModel(R.drawable.icecream, "dessert"))
        recyclerView = findViewById(R.id.rv_1) // rv_1을 recyclerView변수에 대입

        staticRvAdapter = StaticRvAdapter(item, this, this)
        recyclerView.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerView.setAdapter(staticRvAdapter)
        items = ArrayList()
        recyclerView2 = findViewById(R.id.rv_2)
        dynamicRVAdapter = DynamicRVAdapter(items)
        recyclerView2.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        )
        recyclerView2.setAdapter(dynamicRVAdapter)
    }

    override fun callback(position: Int, items: ArrayList<DynamicRVModel>) {
        dynamicRVAdapter = DynamicRVAdapter(items)
        dynamicRVAdapter!!.notifyDataSetChanged()
        recyclerView2!!.adapter = dynamicRVAdapter
    }
}