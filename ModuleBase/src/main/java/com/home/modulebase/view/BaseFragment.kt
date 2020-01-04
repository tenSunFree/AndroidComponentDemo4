package com.home.modulebase.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.home.modulebase.extention.removeParent

abstract class BaseFragment : Fragment() {

    protected abstract val contentView: Int

    private var rootView: FrameLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (contentView > 0 && rootView == null) { // 第一次的時候加載xml
            val contentView = inflater.inflate(contentView, null)
            if (contentView is FrameLayout) {
                contentView.layoutParams = ViewGroup.LayoutParams(-1, -1)
                rootView = contentView
            } else {
                rootView = FrameLayout(context!!)
                rootView?.layoutParams = ViewGroup.LayoutParams(-1, -1)
                rootView?.addView(contentView, ViewGroup.LayoutParams(-1, -1))
            }
        } else { // 防止重新創建時還存在
            rootView?.removeParent()
        }
        return rootView
    }
}