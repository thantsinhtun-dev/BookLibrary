package com.stone.booklibrary.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stone.booklibrary.R
import com.stone.booklibrary.data.vo.ShelvesVO
import com.stone.booklibrary.mvp.presenter.ShelvesListPresenter
import com.stone.booklibrary.viewholders.ShelvesViewHolder

class ShelvesAdapter (private  val mDelegate:ShelvesListPresenter): RecyclerView.Adapter<ShelvesViewHolder>() {
    private var shelvesList: List<ShelvesVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelvesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shelves,parent,false)
        return  ShelvesViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: ShelvesViewHolder, position: Int) {
        if (shelvesList.isNotEmpty()){
            holder.bindData(shelvesVO = shelvesList[position])
        }
    }

    override fun getItemCount(): Int {
        return shelvesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(shelves: List<ShelvesVO>) {
        this.shelvesList = shelves
        notifyDataSetChanged()

    }
}