package com.example.wallpapers2023

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter2(var wallpaperlist: Wallpaperlist, var wparr1: IntArray) : BaseAdapter() {

    lateinit var imagge : ImageView


    override fun getCount(): Int = wparr1.size

    override fun getItem(position: Int): Any = position

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val ww = LayoutInflater.from(wallpaperlist).inflate(R.layout.walllist,parent,false)

        imagge = ww.findViewById(R.id.wallpitem)


        imagge.setBackgroundResource(wparr1[position])

        return ww
    }

}
