package uz.alisoft.office.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.cherry.doc.DocAdapter
import com.cherry.doc.data.DocGroupInfo
import com.cherry.lib.doc.DocViewerActivity
import com.cherry.lib.doc.bean.DocSourceType
import com.cherry.lib.doc.bean.FileType
import com.cherry.lib.doc.util.FileUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.alisoft.office.R
import uz.alisoft.office.databinding.FragmentHome1Binding
import uz.alisoft.office.ui.home.adapter.DocCellViewHolder
import uz.alisoft.office.util.DocUtil

class HomeFragment1 : Fragment(),OnClickListener,DocCellViewHolder.IDocCellListener {

    private var _binding: FragmentHome1Binding? = null
    private val binding get() = _binding!!
    private val mDocAdapter: DocAdapter by lazy { DocAdapter(this) }
    private val viewModel: HomeViewModel by activityViewModels()

    private val observerData = Observer<List<DocGroupInfo>>{
        mDocAdapter.setDat(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHome1Binding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            v.updatePadding(top = statusBarHeight)
            insets
        }
        binding.mRvDoc.adapter = mDocAdapter
        viewModel.liveData.observe(viewLifecycleOwner,observerData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {

    }

    override fun onItemClick(path: String) {
        if (checkSupport(path)) {
            openDoc(path,DocSourceType.PATH)
        }
    }
    private fun openDoc(path: String,docSourceType: Int,type: Int? = null) {
        DocViewerActivity.launchDocViewer(requireActivity() as AppCompatActivity,docSourceType,path,type)
    }

    fun checkSupport(path: String): Boolean {
        var fileType = FileUtils.getFileTypeForUrl(path)
        Log.e(javaClass.simpleName,"fileType = $fileType")
        if (fileType == FileType.NOT_SUPPORT) {
            return false
        }
        return true
    }
}