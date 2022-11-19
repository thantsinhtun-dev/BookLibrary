package com.stone.booklibrary.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.ShelfVO
import com.stone.booklibrary.delegate.OnClickCheckBoxDelegate
import com.stone.booklibrary.viewholders.AddToShelvesViewHolder

class AddToShelvesAdapter(val mDelegate: OnClickCheckBoxDelegate) :RecyclerView.Adapter<AddToShelvesViewHolder>() {
    var shelvesVO:List<ShelfVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddToShelvesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_addto_shelves,parent,false)
        return  AddToShelvesViewHolder(view,mDelegate )
    }

    override fun onBindViewHolder(holder: AddToShelvesViewHolder, position: Int) {
        if (shelvesVO.isNotEmpty()){
            holder.bindData(shelvesVO[position])
        }
    }

    override fun getItemCount(): Int {
        return shelvesVO.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(shelves: List<ShelfVO>) {
        shelvesVO = shelves
        notifyDataSetChanged()
    }
}