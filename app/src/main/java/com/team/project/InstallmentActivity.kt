package com.team.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.team.project.databinding.ActivityInstallmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstallmentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInstallmentBinding
    private lateinit var retrofit: Retrofit
    lateinit var myApi : InstallmentService
    var itemPrice: Int = 0
    var dkind: String = ""
    var itemName:String =""
    private val recyclerView: RecyclerView by lazy{
        findViewById(R.id.InstallmentList)
    }

    private val recyclerAdapter = InstallmentAdapter(itemClicked = {
        val intent = Intent(this, MapDetailsActivity::class.java)
        startActivity(intent)
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installment)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_installment)

        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        dkind = intent.getStringExtra("depositkind")?.toString()!!
        itemPrice = intent.getStringExtra("price")?.toInt()!!
        itemName = intent.getStringExtra("name")?.toString()!!

        binding.itemPrice.text = itemPrice.toString()
        binding.itemName.text = itemName
        if(dkind == "shortdep"){
            binding.bestrate.text = "3.0"
        }else if(dkind == "longdep"){
            binding.bestrate.text = "2.2"
        }
        var imageView = findViewById<ImageView>(R.id.gifimage)
        Glide.with(this).load(R.raw.gif2).into(imageView)
        getFromAPI()
    }

    private fun getFromAPI() {
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
                            recyclerAdapter.submitList(dto.insitem)
                        }
                    }
                    override fun onFailure(call: Call<InstallmentDto>, t: Throwable) {
                        // 실패 처리에 대한 구현
                    }
                })
        }
    }
}