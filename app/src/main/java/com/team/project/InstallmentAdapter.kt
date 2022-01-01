package com.team.project


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class InstallmentAdapter : ListAdapter<InstallmentModel, InstallmentAdapter.ItemViewHolder>(differ){
   inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){
       fun bind(installmentModel: InstallmentModel){
           val titleText = view.findViewById<TextView>(R.id.installmenttitle)
           val basicvalueText = view.findViewById<TextView>(R.id.basicvalue)
           val primevalueText = view.findViewById<TextView>(R.id.primevalue)
           val periodvalueText = view.findViewById<TextView>(R.id.period)
           val moneyText = view.findViewById<TextView>(R.id.money)

           titleText.text = installmentModel.installname
           basicvalueText.text = installmentModel.baserate
           primevalueText.text = installmentModel.primerate
           periodvalueText.text = installmentModel.insmonth
           //Todo:월납입금액 구하기
//           moneyText.text = installmentModel.
       }
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstallmentAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater.inflate(R.layout.installment_item, parent, false))
    }
    override fun onBindViewHolder(holder: InstallmentAdapter.ItemViewHolder, position: Int){
        holder.bind(currentList[position])
    }
    companion object {

        val differ = object : DiffUtil.ItemCallback<InstallmentModel>() {
            override fun areItemsTheSame(oldItem: InstallmentModel, newItem: InstallmentModel): Boolean {
                return oldItem.installid == newItem.installid
            }

            override fun areContentsTheSame(oldItem: InstallmentModel, newItem: InstallmentModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}