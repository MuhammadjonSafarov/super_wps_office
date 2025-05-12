package uz.alisoft.office.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cherry.lib.doc.util.Constant
import com.cherry.lib.doc.widget.PoiViewer
import uz.alisoft.office.databinding.ActivityWordBinding

class WordActivity : AppCompatActivity() {

    lateinit var binding:ActivityWordBinding
    companion object {
        fun launchDocViewer (activity: AppCompatActivity,path: String?) {
            var intent = Intent(activity, WordActivity::class.java)
            intent.putExtra(Constant.INTENT_DATA_KEY,path)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var path = intent?.getStringExtra(Constant.INTENT_DATA_KEY)
        word2Html(path ?: "")
    }

    fun word2Html(sourceFilePath: String) {
        var mPoiViewer = PoiViewer(this)
        try {
            mPoiViewer?.loadFile(binding.mFlDocContainer, sourceFilePath)
        } catch (e: java.lang.Exception) {
            Toast.makeText(this, "打开失败", Toast.LENGTH_SHORT).show()
        }
    }
}