package com.example.knowyourmp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Dhule : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dhule)

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

        val contact2 = findViewById<Button>(R.id.contact2)
        contact2.setOnClickListener{
            val openURl=Intent(android.content.Intent.ACTION_VIEW)
            openURl.data= Uri.parse("mailto:%20sr[dot]bhamre[at]sansad[dot]nic[dot]in,drsubhashbhamre11[at]gmail[dot]com,dr[dot]subhash[dot]bhamre[at]gmail[dot]com")

            startActivity(openURl)
        }
        val form2 = findViewById<Button>(R.id.form2)
        form2.setOnClickListener{
            val openURl=Intent(android.content.Intent.ACTION_VIEW)
            openURl.data= Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfLSltpSNdVq7pIUZXUGbiDHonxZc0dvzpvAt74uRQdn-E89Q/viewform?usp=sf_link")

            startActivity(openURl)
        }
    }
}