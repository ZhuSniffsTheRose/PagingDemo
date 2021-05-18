package com.zhu.pagingdemo

import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.zhu.pagingdemo.databinding.FlowerItemBinding
import com.zhu.pagingdemo.db.Flower

/**
 * @author Zhu
 * @date 2021/5/18 1:45 PM
 * @desc
 */
class FlowerAdapter : PagingDataAdapter<Flower, FlowerViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        Log.d("heiheihei", "FlowerAdapter onCreateViewHolder:$itemCount")
        return FlowerViewHolder(FlowerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Flower>() {
            override fun areItemsTheSame(oldItem: Flower, newItem: Flower): Boolean {
                Log.d("heiheihei", "FlowerAdapter areItemsTheSame:  ${oldItem.name}  ${newItem.name}")
                return false
            }

            override fun areContentsTheSame(oldItem: Flower, newItem: Flower): Boolean {
                return false
            }
        }
    }
}

class FlowerViewHolder(binding: FlowerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private val nameView = binding.name
    fun bindTo(item: Flower?) {
        nameView.text = item?.name
    }
}
