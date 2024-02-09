package com.example.knowyourmp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.knowyourmp.databinding.ActivitySignupBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class Signup : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var binding:ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.AlreadyRegistered.setOnClickListener {
            intent = Intent(this , HomePage::class.java)
            startActivity(intent)
        }

        binding.ButtonSignup.setOnClickListener {
               val name= binding.FullNameEditText.text.toString()
               val email = binding.EmailIdEditText.text.toString()
               val pass = binding.PasswordEditText.text.toString()
               val confirmpass = binding.ReferralCodeEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty() && confirmpass.isNotEmpty()){
                if (pass == confirmpass){
                    Toast.makeText(this , "Registering", Toast.LENGTH_SHORT).show()
                    firebaseAuth.createUserWithEmailAndPassword(email , pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            intent = Intent(this , MainActivity::class.java)
                            intent.putExtra("Username" , name)
                            intent.putExtra("email" , email)
                            startActivity(intent)
                            Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this , it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this , "Password and Confirm Password does not match", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this , "Please Fill The Required Detail", Toast.LENGTH_SHORT).show()
            }
        }
    }
}