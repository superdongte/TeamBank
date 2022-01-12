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
            val locationText = view.findViewById<TextView>(R.id.banklocation)
            val thumbnailImageView = view.findViewById<ImageView>(R.id.thumbnailIamgeView)

            titleTextView.text = bankModel.branchid
            priceTextView.text = bankModel.banktelephone
            locationText.text = bankModel.banklocation

            view.setOnClickListener {
                itemClicked(bankModel)
            }

            Glide
                .with(thumbnailImageView.context)
                .load(bankModel.bankimg)
                .into(thumbnailImageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater.inflate(R.layout.item_bank_detail, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {

        val differ = object : DiffUtil.ItemCallback<BankModel>() {
            override fun areItemsTheSame(oldItem: BankModel, newItem: BankModel): Boolean {
                return oldItem.bankid == newItem.bankid
            }

            override fun areContentsTheSame(oldItem: BankModel, newItem: BankModel): Boolean {
                return oldItem == newItem
            }

        }
    }

}