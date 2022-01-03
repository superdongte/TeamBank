package com.team.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.team.project.databinding.ActivityChooseDkindBinding

class DkindActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChooseDkindBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_dkind)

        binding.shortinvest.setOnClickListener(View.OnClickListener {
            val dkind = "단기적금"
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("dkind",dkind)
            Toast.makeText(applicationContext,dkind,Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })
        binding.longinvest.setOnClickListener(View.OnClickListener {
            val dkind = "정기예금"
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("dkind",dkind)
            Toast.makeText(applicationContext,dkind,Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })
    }
}