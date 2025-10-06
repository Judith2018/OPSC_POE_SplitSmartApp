package com.example.splitsmart_poe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Login Button - Temporary mock login
        val loginButton = findViewById<Button>(R.id.btnLogin)
        loginButton.setOnClickListener {

            // TODO: Replace with real Firebase login later
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        // For Google login (now a LinearLayout)
        val googleLoginLayout = findViewById<LinearLayout>(R.id.btnGoogleLogin)
        googleLoginLayout.setOnClickListener {
            Toast.makeText(this, "Google login - to be implemented", Toast.LENGTH_SHORT).show()
        }

// For Apple login (now a LinearLayout)
        val appleLoginLayout = findViewById<LinearLayout>(R.id.btnAppleLogin)
        appleLoginLayout.setOnClickListener {
            Toast.makeText(this, "Apple login - to be implemented", Toast.LENGTH_SHORT).show()
        }

        // Sign Up Link - Go to SignUpActivity
        val signUpText = findViewById<TextView>(R.id.tvSignUp)
        signUpText.setOnClickListener {
            //val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}


