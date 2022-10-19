package com.example.mihir_018_p_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOpenTime: Button = findViewById(R.id.btnOpenTime)
        btnOpenTime.setOnClickListener {
            Intent(this, TimeActivty::class.java).also {
                startActivity(it)
            }
        }
    }
}