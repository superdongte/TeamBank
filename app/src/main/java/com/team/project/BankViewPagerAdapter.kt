package com.team.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class BankViewPagerAdapter(val itemClicked: (BankModel) -> Unit): ListAdapter<BankModel, BankViewPagerAdapter.ItemViewHolder>(differ) {

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(bankModel: BankModel) {
            val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
            val priceTextView = view.findViewById<TextView>(R.id.telephonenumber)
            val thumbnailImageView = view.findViewById<ImageView>(R.id.thumbnailIamgeView)

            titleTextView.text = bankModel.name
            priceTextView.text = bankModel.telephonenum

            view.setOnClickListener {
                itemClicked(bankModel)
            }

            Glide
                .with(thumbnailImageView.context)
                .load(bankModel.imgUrl)
                .into(thumbnailImageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater.inflate(R.layout.item_house_detail_for_viewpager, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {

        val differ = object : DiffUtil.ItemCallback<BankModel>() {
            override fun areItemsTheSame(oldItem: BankModel, newItem: BankModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: BankModel, newItem: BankModel): Boolean {
                return oldItem == newItem
            }

        }
    }

}