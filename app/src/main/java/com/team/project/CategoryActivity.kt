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
        var itemValue = intent.getStringExtra("itemprice")
        var dkind = intent.getStringExtra("dkind")
        var person = intent.getStringExtra("genage")
        binding.longinstall.setOnClickListener(View.OnClickListener {
            val deposit:String ="예적금상품을 선택해주세요"
            val intent = Intent(this, DepositActivity::class.java)
            intent.putExtra("itemprice",itemValue)
            intent.putExtra("type",deposit)
            intent.putExtra("dkind",dkind)
            startActivity(intent)
        })
        binding.goodsinstall.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ChooseGoodsActivity::class.java)
            intent.putExtra("person",person)
            intent.putExtra("dkind",dkind)
            startActivity(intent)
        })
    }
}