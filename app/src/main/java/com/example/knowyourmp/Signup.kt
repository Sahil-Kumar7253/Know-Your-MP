package com.example.knowyourmp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Signup : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signup = findViewById<Button>(R.id.sigmup2)

        signup.setOnClickListener {
            intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Signed IN ", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
    companion object {
        val pref: String = "Hello"
    }
}