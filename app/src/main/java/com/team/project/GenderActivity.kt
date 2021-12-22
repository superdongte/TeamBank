package com.team.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.team.project.databinding.ActivityGenderBinding


class GenderActivity : AppCompatActivity() {

    //databinding 초기화
    private lateinit var binding : ActivityGenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gender)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_gender)

        binding.woman.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AgeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra("woman","F")
            startActivity(intent)
            Toast.makeText(applicationContext,"F",Toast.LENGTH_SHORT).show()
        })

        binding.man.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AgeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra("man","M")
            startActivity(intent)
            Toast.makeText(applicationContext,"M",Toast.LENGTH_SHORT).show()
        })

    }


}