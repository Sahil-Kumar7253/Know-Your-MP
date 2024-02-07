package com.example.knowyourmp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Nanded : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nanded)
        val home = findViewById<ImageButton>(R.id.home)
        home.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        val news = findViewById<ImageButton>(R.id.setting)
        news.setOnClickListener {
            startActivity( Intent(this , NewsHighlights::class.java))
        }
        val help = findViewById<ImageButton>(R.id.help)

        help.setOnClickListener {
            startActivity( Intent(this , HelpActivity::class.java))
        }
        val contact4 = findViewById<Button>(R.id.contact4)
        contact4.setOnClickListener{
            val openURl=Intent(android.content.Intent.ACTION_VIEW)
            openURl.data= Uri.parse("mailto:%20krishnanama[dot]2[at]gmail[dot]com,pp[dot]chijhlikar[at]sansad[dot]nic[dot]in")

            startActivity(openURl)
        }
        val form4 = findViewById<Button>(R.id.form4)
        form4.setOnClickListener{
            val openURl=Intent(android.content.Intent.ACTION_VIEW)
            openURl.data= Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfLSltpSNdVq7pIUZXUGbiDHonxZc0dvzpvAt74uRQdn-E89Q/viewform?usp=sf_link")

            startActivity(openURl)
        }
    }
}