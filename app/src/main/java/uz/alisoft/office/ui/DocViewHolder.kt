package uz.alisoft.office.ui

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

class DocViewHolder(private val binding:RvDocCellBinding)
    : RecyclerView.ViewHolder(binding.root),OnClickListener {
    var mOnItemClickListener: OnItemClickListener? = null

    init {
        binding.root.setOnClickListener(this)
    }

    fun bindData(data: DocGroupInfo?) {
        binding.mTvTypeName.text = data?.typeName

//        itemView.mRvDocCell.onFlingListener = null
//        LinearSnapHelper().attachToRecyclerView(itemView.mRvDocCell)

        var cellAdapter = DocCellAdapter(itemView.context,mOnItemClickListener,
            adapterPosition)
        cellAdapter.showDatas(data?.docList)

        binding.mRvDocCell.adapter = cellAdapter
    }

    override fun onClick(v: View?) {
        mOnItemClickListener?.onItemClick(null,v,adapterPosition,0)
    }

}