package com.team.project

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class AgeAdapter(
    private val items: ArrayList<AgeModel>,
    var activity: Activity,
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
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AgeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var imageView: ImageView
        var gridLayout: GridLayout

        init{
            imageView = itemView.findViewById(R.id.thumbnailIamgeView2)
            gridLayout = itemView.findViewById(R.id.linearLayout2)
        }
    }

}