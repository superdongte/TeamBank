package com.team.project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.team.project.databinding.ActivityDepositBinding
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DepositActivity : AppCompatActivity(){
    private lateinit var binding : ActivityDepositBinding


    private val recyclerView: RecyclerView by lazy{
        findViewById(R.id.installmentList)
    }

    private val recyclerAdapter = InstallmentAdapter(itemClicked = {
        val intent = Intent(this, MapDetailsActivity::class.java)
        startActivity(intent)
    })
    var itemPrice: Int = 0
    var dkind :String= ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_deposit)
        Toast.makeText(applicationContext,dkind, Toast.LENGTH_SHORT).show()
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        itemPrice = intent.getStringExtra("itemprice")?.toInt()!!
        dkind = intent.getStringExtra("dkind")?.toString()!!
        val titleView = findViewById<TextView>(R.id.depositname)
        var type = intent.getStringExtra("type")
        titleView.text = type
        var imageView = findViewById<ImageView>(R.id.gifimage1)
        Glide.with(this).load(R.raw.gif3).into(imageView);
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
                            for (i: Int in 0..size)
                                dto.insitem[i].itemPrice = itemPrice
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