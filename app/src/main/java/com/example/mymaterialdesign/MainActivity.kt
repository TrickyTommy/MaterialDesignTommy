package com.example.mymaterialdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Shipping Addres")
    }

    fun save(view: View) {
        startActivity(Intent(this@MainActivity, NormalActivityDesign::class.java))
    }


}