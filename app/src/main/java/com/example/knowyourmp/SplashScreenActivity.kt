package com.example.knowyourmp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val image32  = findViewById<ImageView>(R.id.image32)
        val text32 = findViewById<TextView>(R.id.text32)
        text32.alpha = 0f
        image32.alpha = 0f


        image32.animate().setDuration(3000).alpha(1f).withEndAction{
            val i = Intent(this,LoginPage::class.java)
            startActivity(i)
            finish()
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
        text32.animate().setDuration(3000).alpha(1f).withEndAction{
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
    }
}