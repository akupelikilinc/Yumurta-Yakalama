package com.ahmetkupelikilinc.yumurtayakalama

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startGame(view : View){
        val gameintent = Intent(application, GameActivity::class.java)
        startActivity(gameintent)
    }

    }
