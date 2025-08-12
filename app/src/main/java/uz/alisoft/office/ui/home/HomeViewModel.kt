package uz.alisoft.office.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cherry.doc.data.DocGroupInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.alisoft.office.util.DocUtil

class HomeViewModel() : ViewModel() {
    val liveData = MutableLiveData<List<DocGroupInfo>>()

    fun loadData(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            var datas = DocUtil.getDocFile(context)
            CoroutineScope(Dispatchers.Main).launch {
                liveData.postValue(datas)
            }
        }
    }
}