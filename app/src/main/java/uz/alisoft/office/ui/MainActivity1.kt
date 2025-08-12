/*
package uz.alisoft.office.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cherry.doc.DocAdapter
import com.cherry.lib.doc.DocViewerActivity
import com.cherry.lib.doc.bean.DocSourceType
import com.cherry.lib.doc.bean.FileType
import com.cherry.lib.doc.util.FileUtils
import com.cherry.permissions.lib.EasyPermissions
import com.cherry.permissions.lib.EasyPermissions.hasPermissions
import com.cherry.permissions.lib.annotations.AfterPermissionGranted
import com.cherry.permissions.lib.dialogs.SettingsDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.alisoft.office.R
import uz.alisoft.office.databinding.ActivityMainBinding
import uz.alisoft.office.util.BasicSet
import uz.alisoft.office.util.WordUtils
import java.io.File
import java.io.FileOutputStream


class MainActivity1 : AppCompatActivity(),OnClickListener,OnItemClickListener,
    EasyPermissions.PermissionCallbacks {
    companion object {
        const val REQUEST_CODE_STORAGE_PERMISSION = 124
        const val REQUEST_CODE_STORAGE_PERMISSION11 = 125
        const val REQUEST_CODE_SELECT_DOCUMENT = 0x100
        const val TAG = "MainActivity"
    }

    var url = "http://cdn07.foxitsoftware.cn/pub/foxit/manual/phantom/en_us/API%20Reference%20for%20Application%20Communication.pdf"
//    var url = "https://xdts.xdocin.com/demo/resume3.docx"
//    var url = "http://172.16.28.95:8080/data/test2.ppt"
//    var url = "http://172.16.28.95:8080/data/testdocx.ll"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
    }

    private fun hasRwPermission(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val isExternalStorageManager = Environment.isExternalStorageManager()
            return isExternalStorageManager
        }
        val read = hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val write = hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        return read && write
    }

    @AfterPermissionGranted(REQUEST_CODE_STORAGE_PERMISSION)
    private fun requestStoragePermission() {
        if (hasRwPermission()) {
           // viewModel.loadData(this)
        } else {
            // Ask for one permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                get11Permission()
                return
            }
            EasyPermissions.requestPermissions(
                this,
                "This app needs access to your storage to load local doc",
                REQUEST_CODE_STORAGE_PERMISSION,
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }
    }

    fun get11Permission() {
        try {
            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            intent.addCategory("android.intent.category.DEFAULT")
            intent.data = Uri.parse(java.lang.String.format("package:%s", packageName))
            startActivityForResult(intent, REQUEST_CODE_STORAGE_PERMISSION11)
        } catch (e: Exception) {
            val intent = Intent()
            intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
            startActivityForResult(intent, REQUEST_CODE_STORAGE_PERMISSION11)
        }
    }

  */
/*  override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_assets -> {
                openDoc("test.docx",DocSourceType.ASSETS)
                return true
            }
            R.id.action_online -> {
                openDoc(url,DocSourceType.URL,null)
                return true
            }
            R.id.action_select -> {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
               intent.setType("")
                startActivityForResult(intent, REQUEST_CODE_SELECT_DOCUMENT)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    *//*


    fun initData() {
        requestStoragePermission()
        val intent = intent
        val action = intent.action
        val type = intent.type
        if (Intent.ACTION_VIEW == action && type != null) {
            val pdfUri = intent.data
            if (pdfUri != null) {
                    when (pdfUri.scheme) {
                        "content" -> {
                            val fileName = "temp_file_${System.currentTimeMillis()}.${FileUtils.getFileFormatForUrl(pdfUri.path)}"
                            val file = copyUriToInternalStorage(this,pdfUri,fileName)
                            openDoc(file?.absolutePath!!,DocSourceType.PATH)
                        }
                        "file" -> {
                            // file:// turidagi URI – to‘g‘ridan-to‘g‘ri fayl sifatida o‘qish mumkin
                            openDoc(pdfUri.path!!,DocSourceType.PATH)
                        }
                        else -> {}
                    }
           } else {
                Toast.makeText(this, "Fayl topilmadi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun copyUriToInternalStorage(context: Context, uri: Uri, fileName: String): File? {
        val inputStream = context.contentResolver.openInputStream(uri) ?: return null
        val file = File(context.cacheDir, fileName)
        val outputStream = FileOutputStream(file)

        inputStream.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }

        return file
    }

    override fun onClick(v: View?) {
        when (v?.id) {
        }
    }

    fun checkSupport(path: String): Boolean {
        var fileType = FileUtils.getFileTypeForUrl(path)
        Log.e(javaClass.simpleName,"fileType = $fileType")
        if (fileType == FileType.NOT_SUPPORT) {
            return false
        }
        return true
    }

    fun openDoc(path: String,docSourceType: Int,type: Int? = null) {
        DocViewerActivity.launchDocViewer(this,docSourceType,path,type)
    }

    override fun onItemClick(p0: AdapterView<*>?, v: View?, position: Int, id: Long) {
        when (v?.id) {
         */
/*   R.id.mCvDocCell -> {
                val groupInfo = mDocAdapter?.datas?.get(id.toInt())
                val docInfo = groupInfo?.docList?.get(position)
                var path = docInfo?.path ?: ""
                if (checkSupport(path)) {
                    openDoc(path,DocSourceType.PATH)
                }*//*


//                word2Html(path)
//                WordActivity.launchDocViewer(this,path)
            //}
        }
    }

    fun word2Html(sourceFilePath: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val htmlFilePath = cacheDir.absolutePath + "/html"
            val htmlFileName = "word_pdf"

            var bs = BasicSet(this@MainActivity1,sourceFilePath,htmlFilePath, htmlFileName)
            bs.picturePath = htmlFilePath

            WordUtils.getInstance(bs).word2html()
            CoroutineScope(Dispatchers.Main).launch {

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_STORAGE_PERMISSION11) {
            if (hasRwPermission()) {
                requestStoragePermission()
            }
        } else if (requestCode == REQUEST_CODE_SELECT_DOCUMENT && resultCode == RESULT_OK) {
            val documentUri = data?.data
            Log.d(TAG, "documentUri = $documentUri")
            documentUri?.let {
                openDoc(it.toString(), DocSourceType.URI, null)
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    // ============================================================================================
    //  Implementation Permission Callbacks
    // ============================================================================================

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        // (Optional) Check whether the user denied any permissions and checked "NEVER ASK AGAIN."
        // This will display a dialog directing them to enable the permission in app settings.
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {

            val settingsDialogBuilder = SettingsDialog.Builder(this)

            when(requestCode) {
                REQUEST_CODE_STORAGE_PERMISSION -> {
                    settingsDialogBuilder.title = getString(
                        com.cherry.permissions.lib.R.string.title_settings_dialog,
                        "Storage Permission")
                    settingsDialogBuilder.rationale = getString(
                        com.cherry.permissions.lib.R.string.rationale_ask_again,
                        "Storage Permission")
                }
            }
            settingsDialogBuilder.build().show()
        }
    }
}*/
