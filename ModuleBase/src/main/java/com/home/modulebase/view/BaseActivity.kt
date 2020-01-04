package com.home.modulebase.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.FragmentUtils
import kotlinx.android.synthetic.main.base_activity_base.*
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val contentView: Int

    private var currentFragment: Fragment = Fragment()
    var fragmentList: MutableList<Fragment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView)
    }

    /**
     * 設置選中的fragment
     */
    fun selectFragment(index: Int) {
        if (fragmentList.size == 0) {
            toast("fragmentList.size == 0")
            return
        }
        // 需要顯示的fragment
        val fragment = fragmentList[index]
        // 和當前選中的一樣, 則不再處理
        if (currentFragment == fragment) return
        // 先關閉之前顯示的
        currentFragment.let { FragmentUtils.hide(it) }
        // 設置現在需要顯示的
        currentFragment = fragment
        if (!fragment.isAdded) { // 沒有添加, 則添加並顯示
            val tag = fragment::class.java.simpleName
            FragmentUtils.add(
                supportFragmentManager,
                fragment,
                constraint_layout_container.id,
                tag,
                false
            )
        } else { // 添加了就直接顯示
            FragmentUtils.show(fragment)
        }
    }
}