package com.example.fb1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (UserSession.username == "") {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        var name = findViewById<TextView>(R.id.name)
        name.text = "Hello, ${UserSession.username}"

        var signout = findViewById<TextView>(R.id.signout)

        signout.setOnClickListener {
            UserSession.username = ""
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}