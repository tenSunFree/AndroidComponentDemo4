package com.home.modulemessage.view

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.home.modulebase.extention.click
import com.home.modulebase.view.BaseFragment
import com.home.modulemessage.R
import kotlinx.android.synthetic.main.message_fragment_message.*
import org.jetbrains.anko.support.v4.toast

class MessageFragment : BaseFragment() {

    companion object {
        fun newInstance(activity: AppCompatActivity): Fragment {
            val fragment = MessageFragment()
            fragment.activity = activity
            return fragment
        }
    }

    lateinit var activity: AppCompatActivity
    override val contentView: Int
        get() = R.layout.message_fragment_message

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toast("MessageFragment, onViewCreated")
        initializeView()
    }

    private fun initializeView() {
        text_view.typeface = Typeface.createFromAsset(activity.assets, "fonts/Quentin.otf")
        Glide.with(this).load(R.drawable.icon_message_fragment_message).into(image_view)
        text_view.click {
            toast("MessageFragment")
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            toast("MessageFragment, onHiddenChanged")
        }
    }
}