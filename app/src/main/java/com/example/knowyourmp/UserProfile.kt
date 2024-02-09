package com.example.knowyourmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val name =  intent.getStringExtra("Username")
        val email = intent.getStringExtra("email")

//        findViewById<TextView>(R.id.displayname).text = name
//        findViewById<TextView>(R.id.emailid).text = email

    }
}