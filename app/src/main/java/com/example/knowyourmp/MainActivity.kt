package com.example.knowyourmp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.callbackFlow

class MainActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient:GoogleSignInClient
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val autoState  = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val state  = resources.getStringArray(R.array.State)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_state,state)
        val news = findViewById<ImageButton>(R.id.setting)
        news.setOnClickListener {
            startActivity( Intent(this , NewsHighlights::class.java))
        }
        val help = findViewById<ImageButton>(R.id.help)

        help.setOnClickListener {
            startActivity( Intent(this , HelpActivity::class.java))
        }

        val videoView= findViewById<VideoView>(R.id.xml_video_view)
        val packageName = "android.resource://" + getPackageName() + "/" + R.raw.video
        val uri= Uri.parse(packageName)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)

        autoState.setAdapter(arrayAdapter)

        autoState.onItemClickListener = AdapterView.OnItemClickListener {
          adapterView, view, i, l ->

           val stateSelected = adapterView.getItemAtPosition(i)
        }

        val proceed =  findViewById<Button>(R.id.proceed)
        val user = findViewById<ImageView>(R.id.UserImage)

        user.setOnClickListener {
            intent = Intent(applicationContext,UserProfile::class.java)
            startActivity(intent)
        }

        proceed.setOnClickListener {
            intent = Intent(applicationContext, Maharshtra::class.java)
            startActivity(intent)
        }
        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        findViewById<Button>(R.id.google).setOnClickListener {
            signInGoogle()
        }

//        val email = intent.getStringExtra("email")
//        val displayName = intent.getStringExtra("name")


        findViewById<Button>(R.id.signout).setOnClickListener {
            auth.signOut()
            startActivity(Intent(this , LoginPage::class.java))
            Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show()
        }
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