package com.team.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.team.project.databinding.ActivityGoodsdeplistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GoodsDeplistActivity : AppCompatActivity(){
    private lateinit var binding : ActivityGoodsdeplistBinding
    private lateinit var retrofit: Retrofit
    lateinit var myApi : InstallmentService
    var itemPrice: Int = 0
    var dkind: String = ""
    var genage: String = ""
    //    var itemName:String =""
    private val goodsrecyclerAdapter = GoodsListAdapter(itemClicked = {
        itemPrice= it.itemprice
        getFromDepoistAPI()
    })
    private val itemrecyclerView: RecyclerView by lazy{
        findViewById(R.id.goodsRecyclerView)
    }
    private val depositrecyclerView: RecyclerView by lazy{
        findViewById(R.id.InstallmentList)
    }

    private val depositrecyclerAdapter = InstallmentAdapter(itemClicked = {
        val intent = Intent(this, MapDetailsActivity::class.java)
        startActivity(intent)
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installment)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_goodsdeplist)

        depositrecyclerView.adapter = depositrecyclerAdapter
        depositrecyclerView.layoutManager = LinearLayoutManager(this)
        itemrecyclerView.adapter = goodsrecyclerAdapter
        itemrecyclerView.layoutManager = LinearLayoutManager(this).also { it.orientation=LinearLayoutManager.HORIZONTAL }

        binding.goodsPic1.setOnClickListener(View.OnClickListener {
            Log.d("MyTag", "click goodsPic1")
            val intent = Intent(this, InstallmentActivity::class.java)
            itemPrice=4000000
            getFromDepoistAPI()
        })
        binding.goodsPic2.setOnClickListener(View.OnClickListener {
            Log.d("MyTag", "click goodsPic2")
            val intent = Intent(this, InstallmentActivity::class.java)
            itemPrice=5000000
            getFromDepoistAPI()
        })
        binding.goodsPic3.setOnClickListener(View.OnClickListener {
            Log.d("MyTag", "click goodsPic3")
            val intent = Intent(this, InstallmentActivity::class.java)
            itemPrice=3000000
            getFromDepoistAPI()
        })

        dkind = intent.getStringExtra("dkind")!!
        itemPrice = intent.getStringExtra("itemprice")?.toInt()!!
        genage = intent.getStringExtra("genage")!!
//        itemName = intent.getStringExtra("name")?.toString()!!

        getFromGoodsAPI()
        getFromDepoistAPI()
    }
    private fun getFromDepoistAPI() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8083/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(InstallmentService::class.java).also {
            it.getInstallmentList(dkind)
                .enqueue(object : Callback<InstallmentDto> {
                    override fun onResponse(call: Call<InstallmentDto>, response: Response<InstallmentDto>) {
                        if (response.isSuccessful.not()) {
                            // 실패 처리에 대한 구현
                            return
                        }
                        response.body()?.let { dto ->
                            val size = dto.insitem.size - 1
                            for (i: Int in 0..size) {
                                dto.insitem[i].itemPrice = itemPrice
                            }
                            depositrecyclerAdapter.submitList(dto.insitem)
                        }
                    }
                    override fun onFailure(call: Call<InstallmentDto>, t: Throwable) {
                        // 실패 처리에 대한 구현
                    }
                })
        }
    }
    private fun getFromGoodsAPI() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8083/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(GoodsService::class.java).also {
            it.getGoodsList(genage)
                .enqueue(object : Callback<GoodsDto> {
                    override fun onResponse(call: Call<GoodsDto>, response: Response<GoodsDto>) {
                        if (response.isSuccessful.not()) {
                            // 실패 처리에 대한 구현
                            return
                        }
                        response.body()?.let { dto ->
                            goodsrecyclerAdapter.submitList(dto.items)
                        }
                    }
                    override fun onFailure(call: Call<GoodsDto>, t: Throwable) {
                        // 실패 처리에 대한 구현
                    }
                })
        }
    }
}