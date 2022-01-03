package com.team.project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_deposit)

        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val titleView = findViewById<TextView>(R.id.depositname)
        var type = intent.getStringExtra("type")
        titleView.text = type
        var imageView = findViewById<ImageView>(R.id.gifimage1)
        Glide.with(this).load(R.raw.gif1).into(imageView);

//        binding.cardview.setOnClickListener(View.OnClickListener {
//            Log.d("MyTag","click textView1")
//            val intent = Intent(this, MapDetailsActivity::class.java)
//            startActivity(intent)
//        })
        getFromAPI()
    }
    private fun getFromAPI() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io")
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