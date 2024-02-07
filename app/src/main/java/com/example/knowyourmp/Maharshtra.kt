package com.example.knowyourmp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class Maharshtra : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maharshtra)

        val autoDistrict  = findViewById<AutoCompleteTextView>(R.id.district)
        val district  = resources.getStringArray(R.array.District)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_state,district)
        val proceed1 =  findViewById<Button>(R.id.proceedd)
        val home = findViewById<ImageButton>(R.id.home)
        autoDistrict.setAdapter(arrayAdapter)
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
        autoDistrict.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            val stateSelected = adapterView.getItemAtPosition(i)
            proceed1.setOnClickListener {
                if (stateSelected == "Maval"){
                    intent = Intent(applicationContext, maval::class.java)
                    startActivity(intent)
                }
                if (stateSelected == "Dhule"){
                    intent = Intent(applicationContext, Dhule::class.java)
                    startActivity(intent)
                }
                if (stateSelected == "Yavatmal-Washim"){
                    intent = Intent(applicationContext, YavatmalWashim::class.java)
                    startActivity(intent)
                }
                if (stateSelected == "Nanded"){
                    intent = Intent(applicationContext, Nanded::class.java)
                    startActivity(intent)
                }
                if (stateSelected == "Jalna"){
                    intent = Intent(applicationContext, Jalna::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}