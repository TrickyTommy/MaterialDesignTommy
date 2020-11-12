package com.example.mymaterialdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NormalActivityDesign : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_design)
        setTitle("")
    }
    fun next(view: View) {
        startActivity(Intent(this@NormalActivityDesign, NormalMatrialDesignNothree::class.java))

    }
}