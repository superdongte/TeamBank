package com.team.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.team.project.databinding.ActivityInstallmentBinding

class InstallmentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInstallmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installment)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_installment)

        binding.textView1.setOnClickListener(View.OnClickListener {
            Log.d("MyTag","click textView1")
            val intent = Intent(this, MapDetailsActivity::class.java)
            startActivity(intent)
        })
    }
}