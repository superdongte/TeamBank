package com.team.project

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class StaticRvAdapter(//변수명 items로 arraylist 만들기
    private val items: ArrayList<StaticRvModel>,
    var activity: Activity,
    var updateRecyclerView: UpdateRecyclerView
) : RecyclerView.Adapter<StaticRvAdapter.StaticRVViewHolder>() {
    //private Map<String, String> test; // 변수명 test로 Map만들기
    var row_index = -1 //
    var check = true
    var select = true
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaticRVViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.static_rv_item, parent, false)
        return StaticRVViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: StaticRVViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val currentItem = items[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.textView.text = currentItem.text
        if (check) {
            val items = ArrayList<DynamicRVModel>()
            items.add(DynamicRVModel("burger 1", R.drawable.burger_png, 0))
            items.add(DynamicRVModel("burger 2", R.drawable.burger_png, 0))
            items.add(DynamicRVModel("burger 3", R.drawable.burger_png, 0))
            items.add(DynamicRVModel("burger 4", R.drawable.burger_png, 0))
            items.add(DynamicRVModel("burger 5", R.drawable.burger_png, 0))
            items.add(DynamicRVModel("burger 6", R.drawable.burger_png, 0))
            items.add(DynamicRVModel("burger 7", R.drawable.burger_png, 0))
            items.add(DynamicRVModel("burger 8", R.drawable.burger_png, 0))
            items.add(DynamicRVModel("burger 9", R.drawable.burger_png, 0))
            updateRecyclerView.callback(position, items)
            check = false
        }
        holder.linearLayout.setOnClickListener {
            row_index = position
            notifyDataSetChanged()
            if (position == 0) {
                val items = ArrayList<DynamicRVModel>()
                items.add(DynamicRVModel("burger 1", R.drawable.burger_png, 0))
                items.add(DynamicRVModel("burger 2", R.drawable.burger_png, 0))
                items.add(DynamicRVModel("burger 3", R.drawable.burger_png, 0))
                items.add(DynamicRVModel("burger 4", R.drawable.burger_png, 0))
                items.add(DynamicRVModel("burger 5", R.drawable.burger_png, 0))
                items.add(DynamicRVModel("burger 6", R.drawable.burger_png, 0))
                items.add(DynamicRVModel("burger 7", R.drawable.burger_png, 0))
                items.add(DynamicRVModel("burger 8", R.drawable.burger_png, 0))
                items.add(DynamicRVModel("burger 9", R.drawable.burger_png, 0))
                updateRecyclerView.callback(position, items)
            } else if (position == 1) {
                val items = ArrayList<DynamicRVModel>()
                items.add(DynamicRVModel("pizza 1", R.drawable.pizza_png, 1))
                items.add(DynamicRVModel("pizza 2", R.drawable.pizza_png, 1))
                items.add(DynamicRVModel("pizza 3", R.drawable.pizza_png, 1))
                items.add(DynamicRVModel("pizza 4", R.drawable.pizza_png, 1))
                items.add(DynamicRVModel("pizza 5", R.drawable.pizza_png, 1))
                items.add(DynamicRVModel("pizza 6", R.drawable.pizza_png, 1))
                items.add(DynamicRVModel("pizza 7", R.drawable.pizza_png, 1))
                items.add(DynamicRVModel("pizza 8", R.drawable.pizza_png, 1))
                items.add(DynamicRVModel("pizza 9", R.drawable.pizza_png, 1))
                updateRecyclerView.callback(position, items)
            } else if (position == 2) {
                val items = ArrayList<DynamicRVModel>()
                items.add(DynamicRVModel("fries 1", R.drawable.fries_png, 2))
                items.add(DynamicRVModel("fries 2", R.drawable.fries_png, 2))
                items.add(DynamicRVModel("fries 3", R.drawable.fries_png, 2))
                items.add(DynamicRVModel("fries 4", R.drawable.fries_png, 2))
                items.add(DynamicRVModel("fries 5", R.drawable.fries_png, 2))
                items.add(DynamicRVModel("fries 6", R.drawable.fries_png, 2))
                items.add(DynamicRVModel("fries 7", R.drawable.fries_png, 2))
                items.add(DynamicRVModel("fries 8", R.drawable.fries_png, 2))
                items.add(DynamicRVModel("fries 9", R.drawable.fries_png, 2))
                updateRecyclerView.callback(position, items)
            } else if (position == 3) {
                val items = ArrayList<DynamicRVModel>()
                items.add(DynamicRVModel("sandwich 1", R.drawable.sandwitch_png, 3))
                items.add(DynamicRVModel("sandwich 2", R.drawable.sandwitch_png, 3))
                items.add(DynamicRVModel("sandwich 3", R.drawable.sandwitch_png, 3))
                items.add(DynamicRVModel("sandwich 4", R.drawable.sandwitch_png, 3))
                items.add(DynamicRVModel("sandwich 5", R.drawable.sandwitch_png, 3))
                items.add(DynamicRVModel("sandwich 6", R.drawable.sandwitch_png, 3))
                items.add(DynamicRVModel("sandwich 7", R.drawable.sandwitch_png, 3))
                items.add(DynamicRVModel("sandwich 8", R.drawable.sandwitch_png, 3))
                items.add(DynamicRVModel("sandwich 9", R.drawable.sandwitch_png, 3))
                updateRecyclerView.callback(position, items)
            } else if (position == 4) {
                val items = ArrayList<DynamicRVModel>()
                items.add(DynamicRVModel("dessert 1", R.drawable.dessert_png, 4))
                items.add(DynamicRVModel("dessert 2", R.drawable.dessert_png, 4))
                items.add(DynamicRVModel("dessert 3", R.drawable.dessert_png, 4))
                items.add(DynamicRVModel("dessert 4", R.drawable.dessert_png, 4))
                items.add(DynamicRVModel("dessert 5", R.drawable.dessert_png, 4))
                items.add(DynamicRVModel("dessert 6", R.drawable.dessert_png, 4))
                items.add(DynamicRVModel("dessert 7", R.drawable.dessert_png, 4))
                items.add(DynamicRVModel("dessert 8", R.drawable.dessert_png, 4))
                items.add(DynamicRVModel("dessert 9", R.drawable.dessert_png, 4))
                updateRecyclerView.callback(position, items)
            }
        }
        if (select) {
            if (position == 0) holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg)
            select = false
        } else {
            if (row_index == position) {
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg)
            } else {
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StaticRVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView
        var imageView: ImageView
        var linearLayout: LinearLayout

        init {
            imageView = itemView.findViewById(R.id.image)
            textView = itemView.findViewById(R.id.text)
            linearLayout = itemView.findViewById(R.id.linearLayour)
        }
    }
}