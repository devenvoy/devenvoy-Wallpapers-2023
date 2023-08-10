package com.example.wallpapers2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class loginpage : AppCompatActivity() {

    lateinit var loginbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)

        loginbtn = findViewById(R.id.loginbtn)

        val i1 : Intent = Intent(this,Category::class.java)

        loginbtn.setOnClickListener {
            startActivity(i1);
        }
    }
}