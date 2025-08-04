package uz.alisoft.office.util

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.appbar.AppBarLayout

fun FragmentActivity.makeStatusBarTransparent(isDarkMode: Boolean) {
    window.statusBarColor = Color.TRANSPARENT
    if (isDarkMode) window.decorView.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    else window.decorView.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
}

fun FragmentActivity.setStatusBarColor(color: Int, navColor: Int, isDarkMode: Boolean) {
    when (color) {
        Color.TRANSPARENT -> this.makeStatusBarTransparent(isDarkMode)
        else -> {
            window.statusBarColor = ResourcesCompat.getColor(this.resources, color, null)
            window.navigationBarColor = ResourcesCompat.getColor(this.resources, navColor, null)
            if (isDarkMode) window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    window.decorView.systemUiVisibility =
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                else
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
    }
}
fun Fragment.paddingStatusBar(appbar: AppBarLayout) {
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0)
        result = resources.getDimensionPixelSize(resourceId)
    appbar.setPadding(0, result, 0, 0)
}