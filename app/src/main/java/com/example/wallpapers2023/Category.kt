package com.example.wallpapers2023

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Category : AppCompatActivity() {

    lateinit var gridlayout: GridView

    companion object {

        fun showToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        var catitemImg: IntArray = intArrayOf(
            R.drawable.a1,
            R.drawable.cat1,
            R.drawable.anime1,
            R.drawable.nature2,
            R.drawable.space1,
            R.drawable.flower11,
            R.drawable.animal11,
            R.drawable.bike11,
            R.drawable.car2,
            R.drawable.neon1
        )
        var catitemName = arrayOf(
            "Abstract",
            "Cat",
            "Anime",
            "Nature",
            "Space",
            "Flower",
            "Animal",
            "Bike",
            "Car",
            "Neon"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        gridlayout = findViewById(R.id.gridlayout)

        var adapter = MyAdapter(this@Category, catitemName)

        gridlayout.adapter = adapter


        var i2 = Intent(this@Category, Wallpaperlist::class.java)

        gridlayout.setOnItemClickListener { parent, view, position, id ->

            i2.putExtra("itempos", position)
            showToast(this@Category, catitemName[position])
            startActivity(i2)

        }

    }
}