package cn.djzhao.hencoder.utils

import android.content.res.Resources

class ScreenUtils {
    companion object {
        fun dpToPixel(dp: Float): Float {
            return Resources.getSystem().displayMetrics.density * dp
        }
    }
}