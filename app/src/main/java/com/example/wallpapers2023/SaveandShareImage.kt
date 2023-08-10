package com.example.wallpapers2023

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date


class SaveandShareImage : AppCompatActivity() {


    lateinit var share: Button
    lateinit var download: Button
    lateinit var imageee: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saveand_share_image)

        share = findViewById(R.id.share)
        download = findViewById(R.id.download)
        imageee = findViewById(R.id.imageviww)

        /// Imageview to Bitmap

        val bitmap = imageee.getDrawable().toBitmap()


        // share wallpaper
        share.setOnClickListener {
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

        // download wallpaper

        download.setOnClickListener {
            Log.d("====", "onCreate: $bitmap")
            val root = Environment.getExternalStorageDirectory().toString()
            Log.e("Root", "onCreate: $root")
            val myDir = File("$root/Download/MyWallpaper")
            myDir.mkdirs()
            Log.e("myDir", "onCreate: $myDir")
            val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val fname = "Image$timeStamp.jpg"
            val file = File(myDir, fname)
            Log.e("file", "onCreate: $file")

            if (file.exists()) file.delete()
            try {
                val out = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
//                out.flush()
//                out.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }


        }


    }
}