package com.team.project

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
//TODO: 주의할 사항은 import할 때 ListAdapter 리사이클러뷰
class GoodsListAdapter(val itemClicked: (GoodsModel) -> Unit) : androidx.recyclerview.widget.ListAdapter<GoodsModel,GoodsListAdapter.ItemViewHolder>(differ){

    inner class ItemViewHolder(val view:View) : RecyclerView.ViewHolder(view){
        var goodsPrice: Int = 0


        fun bind(goodsModel: GoodsModel){
            //val goodsName = view.findViewById<TextView>(R.id.item_goodst1)
            val goodsPicture = view.findViewById<ImageView>(R.id.goodsPic1)
            val goodsImage = view.findViewById<ImageView>(R.id.iv1)
            goodsPrice = goodsModel.itemprice
            //goodsName.text = goodsModel.itemname
            Glide
                .with(goodsImage.context)
                .load(goodsModel.image)
                .transform(CenterCrop(), RoundedCorners(dpToPx(goodsImage.context,12)))
                .into(goodsImage)
            view.setOnClickListener{
                itemClicked(goodsModel)
            }
        }
    }

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):ItemViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater.inflate(R.layout.item_choosegoods,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
        holder.bind(currentList[position])
    }

    private fun dpToPx(context: Context, dp: Int): Int{
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            context.resources.displayMetrics).toInt()
    }
    companion object {

        val differ = object : DiffUtil.ItemCallback<GoodsModel>() {
            override fun areItemsTheSame(oldItem: GoodsModel, newItem: GoodsModel): Boolean {
                return oldItem.itemid == newItem.itemid
            }

            override fun areContentsTheSame(oldItem: GoodsModel, newItem: GoodsModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}
