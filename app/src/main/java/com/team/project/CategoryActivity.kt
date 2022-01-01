package com.team.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.team.project.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category)
        var person = intent.getStringExtra("genage")

        binding.shortinstall.setOnClickListener(View.OnClickListener {
            val deposit:String ="단기적금상품을 선택해주세요"
            val intent = Intent(this, DepositActivity::class.java)
            intent.putExtra("type",deposit)
            Toast.makeText(applicationContext,deposit,Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })

        binding.longinstall.setOnClickListener(View.OnClickListener {
            val deposit:String ="장기예금상품을 선택해주세요"
            val intent = Intent(this, DepositActivity::class.java)
            intent.putExtra("type",deposit)
            Toast.makeText(applicationContext,deposit,Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })
        binding.goodsinstall.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ChooseGoodsActivity::class.java)
            intent.putExtra("person",person)
            Toast.makeText(applicationContext,person,Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })
    }
}