package com.example.knowyourmp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class maval : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maval)
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
        val contact1 = findViewById<Button>(R.id.contact1)
        contact1.setOnClickListener{
            val openURl=Intent(android.content.Intent.ACTION_VIEW)
            openURl.data= Uri.parse("mailto:%20sc[dot]barne[at]sansad[dot]nic[dot]in%3C/br%3E%20appabarne[at]gmail[dot]com")
            startActivity(openURl)
        }
        val form1 = findViewById<Button>(R.id.form1)
        form1.setOnClickListener{
            val openURl=Intent(android.content.Intent.ACTION_VIEW)
            openURl.data= Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfLSltpSNdVq7pIUZXUGbiDHonxZc0dvzpvAt74uRQdn-E89Q/viewform?usp=sf_link")

            startActivity(openURl)
        }
    }
}