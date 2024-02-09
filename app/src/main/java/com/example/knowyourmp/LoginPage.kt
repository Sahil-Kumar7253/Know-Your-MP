package com.example.knowyourmp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val signup = findViewById<Button>(R.id.signup)
        val login = findViewById<Button>(R.id.login)
        val guest = findViewById<Button>(R.id.Guest)

        auth = FirebaseAuth.getInstance()
        signup.setOnClickListener {
            intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
        login.setOnClickListener {
            intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
        guest.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("Username1" , "Guest")
//            intent.putExtra("email1" , "Guest123@gmail.com")
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        if(auth.currentUser != null){
            intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
    }
}