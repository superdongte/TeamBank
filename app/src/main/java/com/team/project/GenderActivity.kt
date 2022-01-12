package com.team.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.team.project.databinding.ActivityGenderandageBinding


class GenderActivity : AppCompatActivity() {

    //databinding 초기화
    private lateinit var binding : ActivityGenderandageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genderandage)
        Log.d("test", "oncreate()")
        title = "적금 추천 시스템"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_genderandage)
        val intent = Intent(this, DkindActivity::class.java)
        val send = Intent(this,GoodsDeplistActivity::class.java)
        var gender: String = "gender"
        var age: String = ""
        binding.woman.setOnClickListener(View.OnClickListener {
            gender = "F"
            binding.woman.setAlpha(255)
            binding.man.setAlpha(55)
        })

        binding.man.setOnClickListener(View.OnClickListener {
            gender = "M"
            binding.man.setAlpha(255)
            binding.woman.setAlpha(55)
        })
        binding.age1.setOnClickListener(View.OnClickListener {
            if(gender == "gender"){
                Toast.makeText(applicationContext,"성별을 선택해주세요",Toast.LENGTH_SHORT).show()
            }else {
                age = "01"
                intent.putExtra("genage", gender + age)
                intent.putExtra("itemprice","300000")
                send.putExtra("itprice","300000")
                startActivity(intent)
            }
        })
        binding.age2.setOnClickListener(View.OnClickListener {
            if(gender == "gender"){
                Toast.makeText(applicationContext,"성별을 선택해주세요",Toast.LENGTH_SHORT).show()
            }else {
                age = "02"
                intent.putExtra("genage", gender + age)
                intent.putExtra("itemprice","1000000")
                send.putExtra("itprice","1000000")
                startActivity(intent)
            }
        })
        binding.age3.setOnClickListener(View.OnClickListener {
            if(gender == "gender"){
                Toast.makeText(applicationContext,"성별을 선택해주세요",Toast.LENGTH_SHORT).show()
            }else {
                age = "03"
                intent.putExtra("genage", gender + age)
                intent.putExtra("itemprice","10000000")
                send.putExtra("itprice","10000000")
                startActivity(intent)
            }
        })
        binding.age4.setOnClickListener(View.OnClickListener {
            if(gender == "gender"){
                Toast.makeText(applicationContext,"성별을 선택해주세요",Toast.LENGTH_SHORT).show()
            }else {
                age = "04"
                intent.putExtra("genage", gender + age)
                intent.putExtra("itemprice","5000000")
                send.putExtra("itprice","5000000")
                startActivity(intent)
            }
        })
        binding.age5.setOnClickListener(View.OnClickListener {
            if(gender == "gender"){
                Toast.makeText(applicationContext,"성별을 선택해주세요",Toast.LENGTH_SHORT).show()
            }else {
                age = "05"
                intent.putExtra("genage", gender + age)
                intent.putExtra("itemprice","5000000")
                send.putExtra("itprice","5000000")
                startActivity(intent)
            }
        })
    }
}
