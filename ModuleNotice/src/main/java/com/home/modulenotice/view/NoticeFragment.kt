package com.home.modulenotice.view

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.home.modulebase.extention.click
import com.home.modulebase.view.BaseFragment
import com.home.modulenotice.R
import kotlinx.android.synthetic.main.notice_fragment_notice.*
import org.jetbrains.anko.support.v4.toast

class NoticeFragment: BaseFragment(){

    companion object {
        fun newInstance(activity: AppCompatActivity): Fragment {
            val fragment = NoticeFragment()
            fragment.activity = activity
            return fragment
        }
    }

    lateinit var activity : AppCompatActivity
    override val contentView: Int
        get() = R.layout.notice_fragment_notice

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toast("NoticeFragment, onViewCreated")
        initializeView()
    }

    private fun initializeView() {
        text_view.typeface = Typeface.createFromAsset(activity.assets, "fonts/Quentin.otf")
        Glide.with(this).load(R.drawable.icon_notice_fragment_notice).into(image_view)
        text_view.click {
            toast("NoticeFragment")
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            toast("NoticeFragment, onHiddenChanged")
        }
    }
}