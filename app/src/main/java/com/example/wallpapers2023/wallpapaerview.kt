package com.example.wallpapers2023

import android.app.WallpaperManager
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.wallpapers2023.Wallpaperlist.Companion.wparr
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date


class wallpapaerview : AppCompatActivity() {


    lateinit var viewwallpaper: ViewPager
    lateinit var apply: Button
    lateinit var download: ImageButton
    lateinit var sharewall: ImageButton

    lateinit var  myDir : File


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpapaerview)


        viewwallpaper = findViewById(R.id.viewwallpaper)
        apply = findViewById(R.id.apply)
        download = findViewById(R.id.download)
        sharewall = findViewById(R.id.share)

        var itemposition = intent.getIntExtra("itemposition", 0)
        var walltemposition = intent.getIntExtra("wallposition", 0)

        var adapter = MyPagerAdapter(this@wallpapaerview, wparr[itemposition])

        viewwallpaper.adapter = adapter

        viewwallpaper.setCurrentItem(walltemposition)



        sharewall.setOnClickListener {

            var aa = viewwallpaper.currentItem

            val currentDrawable = resources.getDrawable(wparr[itemposition][aa], theme)

            val bitmap = (currentDrawable as BitmapDrawable).bitmap

            val bitmapPath: String = MediaStore.Images.Media.insertImage(
                contentResolver,
                bitmap,
                "palette",
                "share palette"
            )
            val bitmapUri = Uri.parse(bitmapPath)
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "image/png"
            intent.putExtra(Intent.EXTRA_STREAM, bitmapUri)
            startActivity(Intent.createChooser(intent, "Share"))

        }


        download.setOnClickListener {


            var aa = viewwallpaper.currentItem

            val currentDrawable = resources.getDrawable(wparr[itemposition][aa], theme)

            val bitmap = (currentDrawable as BitmapDrawable).bitmap

            val androidVersion = Build.VERSION.RELEASE

            val root = Environment.getExternalStorageDirectory().absolutePath



            if (androidVersion.toInt()>11){
                myDir = File("$root/Download/MyWallpaper")
            } else {
                myDir = File("$root/MyWallpaper")
            }


            Log.i("Directory", "==$myDir")
            myDir.mkdirs()

            val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val fname = "Image$timeStamp.jpg"

            val file = File(myDir, fname)

            if (file.exists()) file.delete()
            try {
                val out = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
                out.flush()
                out.close()

                Toast.makeText(this@wallpapaerview , "download Completed." ,Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


        apply.setOnClickListener {

            var aa = viewwallpaper.currentItem

            val currentDrawable = resources.getDrawable(wparr[itemposition][aa], theme)

            val bitmap = (currentDrawable as BitmapDrawable).bitmap

            val wpmanger = WallpaperManager.getInstance(baseContext)

            wpmanger.setBitmap(bitmap)

            Toast.makeText(this@wallpapaerview,"Set Successfully" ,Toast.LENGTH_SHORT).show()

            
        }

    }

}