package com.example.knowyourmp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class HelpActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)


        val news = findViewById<ImageButton>(R.id.setting)
        news.setOnClickListener {
            startActivity( Intent(this , NewsHighlights::class.java))
        }
        val help = findViewById<ImageButton>(R.id.help)

        help.setOnClickListener {
            startActivity( Intent(this , HelpActivity::class.java))
        }

        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener {
            startActivity( Intent(this , MainActivity::class.java))
        }
    }
}