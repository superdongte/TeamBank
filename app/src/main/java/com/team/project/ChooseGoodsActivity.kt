package com.team.project

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.team.project.databinding.ActivityChooseGoodsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChooseGoodsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChooseGoodsBinding
    private lateinit var retrofit: Retrofit
    lateinit var myApi : GoodsService
    private val recyclerView:RecyclerView by lazy{
        findViewById(R.id.goodsRecyclerView)
    }

    var kind: String = ""

    private val recyclerAdapter = GoodsListAdapter(itemClicked = {
        val intent = Intent(this, InstallmentActivity::class.java)
        Toast.makeText(applicationContext, it.itemprice.toString(), Toast.LENGTH_LONG).show()
        intent.putExtra("price", it.itemprice.toString())
        intent.putExtra("depositkind", kind)
        startActivity(intent)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_goods)
        Log.d("MyTag","ChooseGoodsActivity onCreate()")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_goods)

        recyclerView.adapter =recyclerAdapter
        recyclerView.layoutManager = GridLayoutManager(this,3)

        var temp = intent.getStringExtra("person")
        temp?.let{Log.i("MyTag", it)}
        kind = intent.getStringExtra("dkind")!!

        retrofit = RetrofitClient.getInstance()
        myApi = retrofit.create(GoodsService::class.java)
        Runnable {
            myApi.getGoodsList(temp).enqueue(object : Callback<GoodsDto> {
                override fun onFailure(call: Call<GoodsDto>, t: Throwable) {
                    Log.d(TAG,t.message!!)
                }
                override fun onResponse(call: Call<GoodsDto>, response: Response<GoodsDto>) {

                    Log.d(TAG,"response : ${response.errorBody()}")
                    Log.d(TAG,"response : ${response.message()}")
                    Log.d(TAG,"response : ${response.code()}")
                    Log.d(TAG,"response : ${response.raw().request().url().url()}")
                    //무슨 url로 api call 을 보냈는지
                    response.body()?.let { dto ->
                        recyclerAdapter.submitList(dto.items)
                    }
                }

            })}.run()
        binding.goodsPic1.setOnClickListener(View.OnClickListener {
            Log.d("MyTag", "click goodsPic1")
            val intent = Intent(this, InstallmentActivity::class.java)
            Toast.makeText(applicationContext,binding.goodsPic1.tag.toString(),Toast.LENGTH_LONG).show()
            intent.putExtra("price", binding.goodsPic1.tag.toString())
            intent.putExtra("name", "UHD TV")
            intent.putExtra("depositkind", kind)
            startActivity(intent)
        })
        binding.goodsPic2.setOnClickListener(View.OnClickListener {
            Log.d("MyTag", "click goodsPic1")
            val intent = Intent(this, InstallmentActivity::class.java)
            intent.putExtra("price", "5000000")
            intent.putExtra("name", "여행가기")
            intent.putExtra("depositkind", kind)
            startActivity(intent)
        })
        binding.goodsPic3.setOnClickListener(View.OnClickListener {
            Log.d("MyTag", "click goodsPic1")
            val intent = Intent(this, InstallmentActivity::class.java)
            intent.putExtra("price", "3000000")
            intent.putExtra("name", "맥북pro")
            intent.putExtra("depositkind" ,kind)
            startActivity(intent)
        })

    }//End of onCreate
    object RetrofitClient{
        private var instance : Retrofit? = null
//        private val gson = GsonBuilder().setLenient().create()
//TODO:http://10.0.2.2:8083
        fun getInstance() : Retrofit{
            if(instance == null){
                instance = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8083/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!
        }
    }
}