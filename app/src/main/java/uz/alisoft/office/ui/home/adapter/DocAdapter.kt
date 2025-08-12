package com.cherry.doc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cherry.doc.data.DocGroupInfo
import uz.alisoft.office.databinding.RvDocCellBinding
import uz.alisoft.office.ui.home.HomeFragment1
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

class DocAdapter(private val listener: DocCellViewHolder.IDocCellListener)
    : RecyclerView.Adapter<DocViewHolder>() {

    private val mDataSet = mutableListOf<DocGroupInfo>()

    fun setDat(docList: List<DocGroupInfo>) {
        mDataSet.clear()
        mDataSet.addAll(docList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvDocCellBinding.inflate(layoutInflater,parent,false)
        return DocViewHolder(binding,listener)
    }

    override fun getItemCount(): Int  = mDataSet.size

    override fun onBindViewHolder(holder: DocViewHolder, position: Int) {
        holder.bindData(mDataSet[position])
    }
}