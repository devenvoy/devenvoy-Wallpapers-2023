package com.example.wallpapers2023

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class MyPagerAdapter(var wallpapaerview: wallpapaerview, var walllist: IntArray) : PagerAdapter() {

    lateinit var wallpapaer: ImageView

    override fun getCount(): Int = walllist.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var pv = LayoutInflater.from(wallpapaerview).inflate(R.layout.pageitem, container, false)

        wallpapaer = pv.findViewById(R.id.wallpapaer)

        wallpapaer.setImageResource(walllist[position])

        container.addView(pv)

        return pv
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(container)
    }
}
