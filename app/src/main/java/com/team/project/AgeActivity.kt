package com.team.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.team.project.databinding.ActivityAgeBinding


class AgeActivity : AppCompatActivity() {

    //databinding 초기화
    private lateinit var binding : ActivityAgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)
        Log.d("MyTag","AgeActivity oncreate()")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_age)

       binding.age1.setOnClickListener(View.OnClickListener {
            Log.d("MyTag","click age1")

            //TODO:다음 액티비티로 넘겨주는 부분(완료)
            val intent = Intent(this, ChooseGoodsActivity::class.java)

            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            var gender = "F"
//            intent.putExtra("gender",gender)
            startActivity(intent)
//            Toast.makeText(applicationContext,gender,Toast.LENGTH_SHORT).show()
        })

        binding.age2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AgeActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })
        binding.age3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AgeActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })
        binding.age4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AgeActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })
        binding.age5.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AgeActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })
        binding.age6.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AgeActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })
        binding.age7.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AgeActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })

    }


}
