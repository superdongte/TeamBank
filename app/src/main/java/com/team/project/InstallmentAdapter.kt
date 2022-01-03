package com.team.project

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.lang.Math.round
import java.lang.String.format

class InstallmentAdapter(val itemClicked: (InstallmentModel) -> Unit) : ListAdapter<InstallmentModel, InstallmentAdapter.ItemViewHolder>(differ){
   inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){
       fun bind(installmentModel: InstallmentModel){

           val titleText = view.findViewById<TextView>(R.id.installmenttitle)
           val basicvalueText = view.findViewById<TextView>(R.id.basicvalue)
           val primevalueText = view.findViewById<TextView>(R.id.primevalue)
           val periodvalueText = view.findViewById<TextView>(R.id.period)
           val bankNameText = view.findViewById<TextView>(R.id.bankkind)
           val moneyText = view.findViewById<TextView>(R.id.money)
           titleText.text = installmentModel.depositname
           basicvalueText.text = installmentModel.baserate.toString()
           primevalueText.text = installmentModel.primerate.toString()
           periodvalueText.text = installmentModel.dmonth.toString()
           bankNameText.text = installmentModel.bankname

           var month = installmentModel.dmonth
           var rate = installmentModel.baserate
           var money = (installmentModel.itemPrice / (month+(month*rate))).toInt()
           moneyText.text = money.toString()

           view.setOnClickListener{
               itemClicked(installmentModel)
           }

           var oldrate:Double = 0.0
           var realrate:Double =0.0
           var list = currentList
           var size = list.size-1
//           for (i:Int in 1..size){
//               var currentrate:Double = basicvalue * (periodvalue+1) / 24
//               if(currentrate > oldrate){
//                   realrate = currentrate
//               }else{
//                   realrate = oldrate
//               }
//           }
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
                return oldItem.depositid == newItem.depositid
            }

            override fun areContentsTheSame(oldItem: InstallmentModel, newItem: InstallmentModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}
