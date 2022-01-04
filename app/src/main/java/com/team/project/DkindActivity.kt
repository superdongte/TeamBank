package com.team.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.team.project.databinding.ActivityChooseDkindBinding

class DkindActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChooseDkindBinding
    private val webView: WebView by lazy{
        findViewById(R.id.dkwebview1)
    }

    private fun initViews(){
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        var url = "http://10.0.2.2:8083"
        webView.loadUrl(url)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_dkind)
        var genderage = intent.getStringExtra("genage")
        var itemValue= intent.getStringExtra("itemprice")
        Toast.makeText(applicationContext,itemValue,Toast.LENGTH_SHORT).show()
        binding.shortinvest.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("itemprice",itemValue)
            intent.putExtra("genage", genderage)
            intent.putExtra("dkind", "shortdep")
            startActivity(intent)
        })
        binding.longinvest.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("itemprice",itemValue)
            intent.putExtra("genage", genderage)
            intent.putExtra("dkind", "longdep")
            startActivity(intent)
        })
        initViews()
    }
}