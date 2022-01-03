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
//        retrofit = RetrofitClient.getInstance()
//        myApi = retrofit.create(InstallmentService::class.java)
        getFromAPI()
        var itemprice = intent.getStringExtra("price")
        var itemName = intent.getStringExtra("name")
        val intent = Intent(this, InstallmentAdapter::class.java)
        intent.putExtra("itemprice",itemprice)
        Toast.makeText(applicationContext, "price:${itemprice} name:${itemName}",Toast.LENGTH_LONG).show()
        binding.itemPrice.text = itemprice
        binding.itemName.text = itemName
        var imageView = findViewById<ImageView>(R.id.gifimage)
        Glide.with(this).load(R.raw.gif2).into(imageView);

    }
//    object RetrofitClient{
//        private var instance : Retrofit? = null
////TODO:http://10.0.2.2:8083
//        fun getInstance() : Retrofit{
//            if(instance == null){
//                instance = Retrofit.Builder()
//                    .baseUrl("http://10.0.2.2:8083/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//            return instance!!
//        }
//    }
    private fun getFromAPI() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(InstallmentService::class.java).also {
            it.getInstallmentList()
                .enqueue(object : Callback<InstallmentDto> {
                    override fun onResponse(call: Call<InstallmentDto>, response: Response<InstallmentDto>) {
                        if (response.isSuccessful.not()) {
                            // 실패 처리에 대한 구현
                            return
                        }
                        response.body()?.let { dto ->
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