package com.team.project

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class BankListAdapter : ListAdapter<BankModel, BankListAdapter.ItemViewHolder>(differ) {

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bind(bankModel: BankModel){
            val bankNameTextView = view.findViewById<TextView>(R.id.titleTextView)//은행지점명
            val bankTelTextView = view.findViewById<TextView>(R.id.telephonenumber)//전화번호
            val locationText = view.findViewById<TextView>(R.id.banklocation)
            val thumbnailImageView = view.findViewById<ImageView>(R.id.thumbnailImageView)

            bankNameTextView.text = bankModel.branchid
            bankTelTextView.text = bankModel.banktelephone
            locationText.text = bankModel.banklocation

            Glide
                .with(thumbnailImageView.context)
                .load(bankModel.bankimg)
                .transform(CenterCrop(), RoundedCorners(dpToPx(thumbnailImageView.context, 12)))
                .into(thumbnailImageView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater.inflate(R.layout.item_house, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    private fun dpToPx(context: Context, dp: Int): Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            context.resources.displayMetrics).toInt()
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