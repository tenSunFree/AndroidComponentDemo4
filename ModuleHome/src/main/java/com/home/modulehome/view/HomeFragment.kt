package com.home.modulehome.view

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.home.modulebase.extention.click
import com.home.modulebase.view.BaseFragment
import com.home.modulehome.R
import kotlinx.android.synthetic.main.home_fragment_home.*
import org.jetbrains.anko.support.v4.toast

class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance(activity: AppCompatActivity): Fragment {
            val fragment = HomeFragment()
            fragment.activity = activity
            return fragment
        }
    }

    lateinit var activity: AppCompatActivity
    override val contentView: Int
        get() = R.layout.home_fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toast("HomeFragment, onViewCreated")
        initializeView()
    }

    private fun initializeView() {
        text_view.typeface = Typeface.createFromAsset(activity.assets, "fonts/Quentin.otf")
        Glide.with(this).load(R.drawable.icon_home_fragment_home).into(image_view)
        text_view.click {
            toast("HomeFragment")
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            toast("HomeFragment, onHiddenChanged")
        }
    }
}