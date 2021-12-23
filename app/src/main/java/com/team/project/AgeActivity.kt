package com.team.project

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//준영 테스트
class AgeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    //private lateinit var binding : ActivityAgeBinding
    private lateinit var ageAdapter: AgeAdapter
    var pos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN
        )//전체화면
        Log.d("MyTag", "AgeActivity")
        setContentView(R.layout.activity_age)
        val item = ArrayList<AgeModel>()
        item.add(AgeModel(R.drawable.age_10, "age_10"))
        item.add(AgeModel(R.drawable.age_20, "age_20"))
        item.add(AgeModel(R.drawable.age_30, "age_30"))
        item.add(AgeModel(R.drawable.age_40, "age_40"))
        item.add(AgeModel(R.drawable.age_50, "age_50"))
        item.add(AgeModel(R.drawable.age_60, "age_60"))
        item.add(AgeModel(R.drawable.age_70, "age_70"))
        recyclerView = findViewById(R.id.ageRecyclerView)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_age)

        ageAdapter = AgeAdapter(item, this)
        recyclerView.setLayoutManager(
            GridLayoutManager(
                this,3
            )
        )
        recyclerView.setAdapter(ageAdapter)
        //test변수에 성별정보
        var test = intent.getStringExtra("gender")

        test?.let { Log.i("test", it) }

/*        var gridview= findViewById<View>(R.id.gridView1) as GridView
        var adapter= GridViewAdapter(this)
        //리스트뷰에 Adapter 설정
        gridview.adapter = adapter



    }

    /* 그리드뷰 어댑터 */
    inner class GridViewAdapter(var context: Context) : BaseAdapter() {

        var items = arrayOf(
            R.drawable.age_10, R.drawable.age_20, R.drawable.age_30,
            R.drawable.age_40, R.drawable.age_50, R.drawable.age_60,
            R.drawable.age_70
        )


        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
            var imageView = ImageView(context)
            imageView.layoutParams = ViewGroup.LayoutParams(300,300)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(5,5,5,5)
            imageView.setImageResource(items[position])
            return imageView
        }

        override fun getCount(): Int {
            return items.size
        }
        //addItem메서드 정의
//        fun addItem(item: ageList) {
//            items.add(item)
//        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

    */
    }
}