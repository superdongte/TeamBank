package com.team.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    }
}