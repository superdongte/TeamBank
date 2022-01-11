package com.team.project

import android.content.Intent
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.team.project.databinding.ActivityTestBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewMain : AppCompatActivity(){
    private lateinit var binding : ActivityTestBinding
    private lateinit var retrofit: Retrofit
    lateinit var myApi : InstallmentService
    var itemPrice: Int = 5000000
    var dkind: String = "shortdep"
    var itemName:String =""
    var kind: String = "shortdep"
    private val goodsrecyclerAdapter = GoodsListAdapter(itemClicked = {
        val intent = Intent(this, InstallmentActivity::class.java)
        Toast.makeText(applicationContext, it.itemprice.toString(), Toast.LENGTH_LONG).show()
        intent.putExtra("name",it.itemname)
        intent.putExtra("price", it.itemprice.toString())
        intent.putExtra("depositkind", kind)
        startActivity(intent)
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

        binding = DataBindingUtil.setContentView(this, R.layout.activity_test)

        depositrecyclerView.adapter = depositrecyclerAdapter
        depositrecyclerView.layoutManager = LinearLayoutManager(this)
        itemrecyclerView.adapter = goodsrecyclerAdapter
        itemrecyclerView.layoutManager = LinearLayoutManager(this).also { it.orientation=LinearLayoutManager.HORIZONTAL }


//        dkind = intent.getStringExtra("depositkind")?.toString()!!
//        itemPrice = intent.getStringExtra("price")?.toInt()!!
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
            it.getGoodsList("F01")
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