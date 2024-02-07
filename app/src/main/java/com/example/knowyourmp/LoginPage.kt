package com.example.knowyourmp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val signup = findViewById<Button>(R.id.signup)

        signup.setOnClickListener {
            intent = Intent(this, Signup::class.java)
            startActivity(intent)
            finish()
        }
    }
}