package com.team.project

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class AgeAdapter(
    private val items: ArrayList<AgeModel>,
    var activity: Activity
) : RecyclerView.Adapter<AgeAdapter.AgeViewHolder>(){
    var row_index = -1
    //    var check = true
//    var select = true
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_age, parent,false)
        return AgeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgeViewHolder, position: Int) {
        var currentItem = items[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView?.context, ChooseGoodsActivity::class.java)
            ContextCompat.startActivity(holder.imageView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class AgeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imageView: ImageView
        var gridLayout: GridLayout

        init{
            imageView = itemView.findViewById(R.id.thumbnailIamgeView2)
            gridLayout = itemView.findViewById(R.id.linearLayout2)
            itemView.setOnClickListener{
                //TODO: 토스트테스트해보기
                //클릭 애니매이션 해보기
            }
        }
    }

}