package com.team.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class DynamicRVAdapter(  //다이나믹RV모델을 담은 ArrayList
    var dynamicRVModels: ArrayList<DynamicRVModel>
) : RecyclerView.Adapter<DynamicRVAdapter.DynamicRvHolder>() {
    private var mListner //
            : OnItemClickListner? = null

    interface OnItemClickListner {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(mListner: OnItemClickListner?) {
        this.mListner = mListner
    }

    inner class DynamicRvHolder(itemView: View, mListner: OnItemClickListner?) :
        RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView: TextView
        var constraintLayout: ConstraintLayout

        init {
            imageView = itemView.findViewById(R.id.image)
            textView = itemView.findViewById(R.id.name)
            constraintLayout = itemView.findViewById(R.id.constraintLayout)
            itemView.setOnClickListener {
                if (mListner != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        mListner.onItemClick(position)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DynamicRvHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dynamic_rv_item_layout, parent, false)
        return DynamicRvHolder(view, mListner)
    }

    override fun onBindViewHolder(holder: DynamicRvHolder, position: Int) {
        val currentItem = dynamicRVModels[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.textView.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return dynamicRVModels.size
    }
}