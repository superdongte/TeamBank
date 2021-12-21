package com.team.Project

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class AgeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyTag", "AgeActivity")
        setContentView(R.layout.activity_age)
        var gridview= findViewById<View>(R.id.gridView1) as GridView
        var adapter= GridViewAdapter(this)
        //리스트뷰에 Adapter 설정
        gridview.adapter = adapter

        //Adapter 안에 아이템의 정보 담기
//        adapter!!.addItem(ageList("10대 이하"))
//        adapter!!.addItem(ageList("20대"))
//        adapter!!.addItem(ageList("30대"))
//        adapter!!.addItem(ageList("40대"))
//        adapter!!.addItem(ageList("50대"))
//        adapter!!.addItem(ageList("60대"))
//        adapter!!.addItem(ageList("70대 이상"))

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
            return 0
        }

        override fun getItemId(position: Int): Long {
            return 0
        }


    }//그리드뷰 어댑터 끝
}