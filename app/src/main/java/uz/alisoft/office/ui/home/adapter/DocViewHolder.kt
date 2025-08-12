package uz.alisoft.office.ui.home.adapter

import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.cherry.doc.DocCellAdapter
import com.cherry.doc.data.DocGroupInfo
import uz.alisoft.office.databinding.RvDocCellBinding

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: DocViewHolder
 * Author: Victor
 * Date: 2023/10/26 10:57
 * Description: 
 * -----------------------------------------------------------------
 */

class DocViewHolder(private val binding:RvDocCellBinding,
                    listener:DocCellViewHolder.IDocCellListener)
    : RecyclerView.ViewHolder(binding.root){
    private val cellAdapter = DocCellAdapter(listener)

    fun bindData(data: DocGroupInfo?) {
        binding.mTvTypeName.text = data?.typeName
        cellAdapter.showDatas(data?.docList)
        binding.mRvDocCell.adapter = cellAdapter
    }
}