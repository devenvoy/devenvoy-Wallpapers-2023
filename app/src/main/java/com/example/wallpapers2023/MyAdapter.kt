package com.example.wallpapers2023

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.wallpapers2023.Category.Companion.catitemImg

class MyAdapter(var category: Category, var catitemName: Array<String>) : BaseAdapter() {

    lateinit var itemImg : ImageView
    lateinit var itemText : TextView

    override fun getCount(): Int = catitemName.size

    override fun getItem(position: Int): Any = position

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var  wv = LayoutInflater.from(category).inflate(R.layout.catitem2,parent,false)

        itemImg = wv.findViewById(R.id.itemImg)
        itemText = wv.findViewById(R.id.itemText)

        itemImg.setBackgroundResource(catitemImg[position])
        itemText.text = catitemName[position]

        return wv
    }


}
