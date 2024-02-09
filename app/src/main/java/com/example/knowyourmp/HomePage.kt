package com.example.knowyourmp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.knowyourmp.databinding.ActivityHomePageBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
//    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.NotRegistered.setOnClickListener{
            intent = Intent(this , Signup::class.java)
            startActivity(intent)
        }
//        firebaseAuth = FirebaseAuth.getInstance()
        auth = FirebaseAuth.getInstance()

        binding.PhoneNumber.setOnClickListener {
            intent = Intent(this , PhoneNumber::class.java)
            startActivity(intent)
        }

        binding.ButtonLogin.setOnClickListener {
            val email = binding.LogEmailIdEditText.text.toString()
            val pass = binding.LogPasswordEditText.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()){

                    auth.signInWithEmailAndPassword(email , pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            intent = Intent(this , MainActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this , it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this , "Please Fill The Required Detail", Toast.LENGTH_SHORT).show()
            }
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.GoogleLogin.setOnClickListener {
            signInGoogle()
        }
//        val email = intent.getStringExtra("email")
//        val displayName = intent.getStringExtra("name")
    }

    private fun signInGoogle(){
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == Activity.RESULT_OK){

            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResults(task)
        }
    }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            if (account != null){
                updateUI(account)
            }
        }else{
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener{
            if (it.isSuccessful){
                val intent = Intent(this , MainActivity::class.java)
                intent.putExtra("email" , account.email)
                intent.putExtra("name" , account.displayName)
                startActivity(intent)
                Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

}