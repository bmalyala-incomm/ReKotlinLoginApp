package com.example.RekotlinLoginApp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("returning success response page")
        setContentView(R.layout.activity_success)
    }

}
