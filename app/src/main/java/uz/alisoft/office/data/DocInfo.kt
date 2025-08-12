package uz.alisoft.office.data

import com.cherry.lib.doc.R

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: DocInfo
 * Author: Victor
 * Date: 2023/10/26 10:30
 * Description: 
 * -----------------------------------------------------------------
 */

class DocInfo {
    var album: String? = null
    var fileName: String? = null
    var path: String? = null
    var mimeType: String? = null
    var lastModified: String? = null
    var fileSize: String? = null

    fun getTypeIcon(): Int {
        if (fileName?.lowercase()?.endsWith("pdf") == true) {
            return R.drawable.pdf_ic
        }
        if (fileName?.lowercase()?.endsWith("doc") == true) {
            return R.drawable.word
        }
        if (fileName?.lowercase()?.endsWith("docx") == true) {
            return R.drawable.word_ic
        }
        if (fileName?.lowercase()?.endsWith("xls") == true) {
            return R.drawable.excel_ic
        }
        if (fileName?.lowercase()?.endsWith("xlsx") == true) {
            return R.drawable.excel
        }
        if (fileName?.lowercase()?.endsWith("ppt") == true) {
            return R.drawable.ppt_ic
        }
        if (fileName?.lowercase()?.endsWith("pptx") == true) {
            return R.drawable.ppt_ic
        }
        if (fileName?.lowercase()?.endsWith("txt") == true) {
            return R.drawable.txt
        }
        return -1
    }

    fun getFileType(): String? {
        try {
            var type = path ?: ""
            return type.substring(type.lastIndexOf(".")).split(".")[1].uppercase()
        } catch (e: Exception) {
            return mimeType
        }

    }
}