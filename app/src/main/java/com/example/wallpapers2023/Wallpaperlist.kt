package com.example.wallpapers2023

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.wallpapers2023.Category.Companion.catitemName
import com.example.wallpapers2023.Category.Companion.showToast

class Wallpaperlist : AppCompatActivity() {

    lateinit var gridlayout2: GridView

    lateinit var backbtn: ImageView
    lateinit var wallname : TextView

    companion object {

        var wparr = arrayOf(
            intArrayOf(
                R.drawable.abstract1,
                R.drawable.abstract2,
                R.drawable.abstract3,
                R.drawable.abstract4,
                R.drawable.abstract5,
                R.drawable.abstract6,
                R.drawable.abstract7,
                R.drawable.abstract8,
                R.drawable.abstract9,
                R.drawable.abstract10,
                R.drawable.abstract11,
                R.drawable.abstract12
            ),
            intArrayOf(
                R.drawable.cat1,
                R.drawable.cat2,
                R.drawable.cat3,
                R.drawable.cat4,
                R.drawable.cat5,
                R.drawable.cat6,
                R.drawable.cat7,
                R.drawable.cat8,
                R.drawable.cat9,
                R.drawable.cat10,
                R.drawable.cat11,
                R.drawable.cat12
            ),
            intArrayOf(
                R.drawable.anime1,
                R.drawable.anime2,
                R.drawable.anime3,
                R.drawable.anime4,
                R.drawable.anime5,
                R.drawable.anime6,
                R.drawable.anime7,
                R.drawable.anime8,
                R.drawable.anime9,
                R.drawable.anime10,
                R.drawable.anime11,
                R.drawable.anime12,
                R.drawable.anime13,
                R.drawable.anime14
            ),
            intArrayOf(
                R.drawable.nature14,
                R.drawable.nature16,
                R.drawable.nature2,
                R.drawable.nature20,
                R.drawable.nature21,
                R.drawable.nature22,
                R.drawable.nature23,
                R.drawable.nature24,
                R.drawable.nature25,
                R.drawable.nature26,
                R.drawable.nature27,
                R.drawable.nature28,
                R.drawable.nature3,
                R.drawable.nature30,
                R.drawable.nature31,
                R.drawable.nature32,
                R.drawable.nature33,
                R.drawable.nature34,
                R.drawable.nature4,
                R.drawable.nature9
            ),
            intArrayOf(
                R.drawable.space1,
                R.drawable.space2,
                R.drawable.space3,
                R.drawable.space4,
                R.drawable.space5,
                R.drawable.space6,
                R.drawable.space7,
                R.drawable.space8,
                R.drawable.space9,
                R.drawable.space10,
                R.drawable.space11,
                R.drawable.space12
            ),
            intArrayOf(
                R.drawable.flower1,
                R.drawable.flower2,
                R.drawable.flower3,
                R.drawable.flower4,
                R.drawable.flower5,
                R.drawable.flower6,
                R.drawable.flower7,
                R.drawable.flower8,
                R.drawable.flower9,
                R.drawable.flower10,
                R.drawable.flower11,
                R.drawable.flower12
            ),
            intArrayOf(
                R.drawable.animal1,
                R.drawable.animal2,
                R.drawable.animal3,
                R.drawable.animal4,
                R.drawable.animal5,
                R.drawable.animal6,
                R.drawable.animal7,
                R.drawable.animal8,
                R.drawable.animal9,
                R.drawable.animal10,
                R.drawable.animal11,
                R.drawable.animal12
            ),
            intArrayOf(
                R.drawable.bike1,
                R.drawable.bike2,
                R.drawable.bike3,
                R.drawable.bike4,
                R.drawable.bike5,
                R.drawable.bike6,
                R.drawable.bike7,
                R.drawable.bike8,
                R.drawable.bike9,
                R.drawable.bike10,
                R.drawable.bike11,
                R.drawable.bike12
            ),
            intArrayOf(
                R.drawable.car1,
                R.drawable.car2,
                R.drawable.car3,
                R.drawable.car4,
                R.drawable.car5,
                R.drawable.car6,
                R.drawable.car7,
                R.drawable.car8,
                R.drawable.car9,
                R.drawable.car10,
                R.drawable.car11,
                R.drawable.car12
            ),
            intArrayOf(
                R.drawable.neon1,
                R.drawable.neon2,
                R.drawable.neon3,
                R.drawable.neon4,
                R.drawable.neon5,
                R.drawable.neon6,
                R.drawable.neon7,
                R.drawable.neon8,
                R.drawable.neon9,
                R.drawable.neon10,
                R.drawable.neon11,
                R.drawable.neon12,
            )
        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaperlist)

        backbtn = findViewById(R.id.backbtn)
        gridlayout2 = findViewById(R.id.gridlayout2)
        wallname = findViewById(R.id.wallname)

        val i3 = Intent(this@Wallpaperlist,wallpapaerview::class.java)

        val itemposition = intent.getIntExtra("itempos",0)

        wallname.text = catitemName[itemposition]

        backbtn.setOnClickListener { finish() }

        var adapter = MyAdapter2(this@Wallpaperlist, wparr[itemposition])

        gridlayout2.adapter = adapter

        gridlayout2.setOnItemClickListener { parent, view, position, id ->
            i3.putExtra("itemposition",itemposition)
            i3.putExtra("wallposition",position)
            startActivity(i3)
        }

    }
}