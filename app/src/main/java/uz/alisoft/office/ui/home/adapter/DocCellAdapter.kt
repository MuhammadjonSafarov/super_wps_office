package com.cherry.doc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.alisoft.office.data.DocInfo
import uz.alisoft.office.databinding.RvDocItemCellBinding
import uz.alisoft.office.ui.home.adapter.DocCellViewHolder
import uz.alisoft.office.ui.home.adapter.DocViewHolder

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: DocAdapter
 * Author: Victor
 * Date: 2023/10/26 10:56
 * Description: 
 * -----------------------------------------------------------------
 */

class DocCellAdapter(private val listener: DocCellViewHolder.IDocCellListener)
    : RecyclerView.Adapter<DocCellViewHolder>() {

    var datas = ArrayList<DocInfo>()

    fun showDatas(docList: ArrayList<DocInfo>?) {
        datas.clear()
        docList?.let { datas.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocCellViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvDocItemCellBinding.inflate(layoutInflater,parent,false)
        return DocCellViewHolder(binding,listener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: DocCellViewHolder, position: Int) {
        holder.bindData(datas[position])
    }
}