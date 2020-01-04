package com.home.modulebase.extention

import android.view.View
import android.view.ViewManager
import com.home.modulebase.R

/**
 * 點擊事件
 */
inline fun View.click(crossinline function: (view: View) -> Unit) {
    this.setOnClickListener {
        val tag = this.getTag(R.id.id_tag_click)
        val millisecond = 1000
        if (tag == null || System.currentTimeMillis() - tag.toString().toLong() > millisecond) {
            this.setTag(R.id.id_tag_click, System.currentTimeMillis())
            function.invoke(it)
        }
    }
}

/**
 * 從父控件移除
 */
fun View.removeParent() {
    val parentTemp = parent
    if (parentTemp is ViewManager) parentTemp.removeView(this)
}
