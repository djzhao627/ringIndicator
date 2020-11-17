package cn.djzhao.hencoder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import cn.djzhao.hencoder.fragment.CycleIndicatorFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragments = ArrayList<Fragment>()
    val titles = listOf<String>("指示器", "空白")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        fragments.size
        fragments.add(CycleIndicatorFragment.newInstance("1", "11"))
        fragments.add(CycleIndicatorFragment.newInstance("2", "22"))
        main_view_pager.adapter=MyAdapter(supportFragmentManager)
        main_tab_layout.setupWithViewPager(main_view_pager)
    }

    inner class MyAdapter(manager: FragmentManager):FragmentPagerAdapter(manager) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }
    }
}