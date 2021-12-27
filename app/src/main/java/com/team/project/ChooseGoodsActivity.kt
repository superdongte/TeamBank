package com.team.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.team.project.databinding.ActivityChooseGoodsBinding

class ChooseGoodsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChooseGoodsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_goods)
        Log.d("MyTag","ChooseGoodsActivity onCreate()")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_goods)

        var temp = intent.getStringExtra("genage")
        temp?.let{Log.i("MyTag", it)}

        binding.goodsPic1.setOnClickListener(View.OnClickListener {
            Log.d("MyTag", "click goodsPic1")
            val intent = Intent(this, InstallmentActivity::class.java)
            startActivity(intent)
        })
        binding.goodsPic2.setOnClickListener(View.OnClickListener {
            Log.d("MyTag", "click goodsPic1")
            val intent = Intent(this, InstallmentActivity::class.java)
            startActivity(intent)
        })
        binding.goodsPic3.setOnClickListener(View.OnClickListener {
            Log.d("MyTag", "click goodsPic1")
            val intent = Intent(this, InstallmentActivity::class.java)
            startActivity(intent)
        })

    }
}