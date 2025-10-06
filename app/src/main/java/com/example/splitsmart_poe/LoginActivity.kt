package com.example.splitsmart_poe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.splitsmart_poe.databinding.ActivityLoginBinding
import com.example.splitsmart_poe.ui.HomeActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : BaseActivity() {
    private var binding: ActivityLoginBinding? = null
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        auth = Firebase.auth

        binding?.tvSignUp?.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
        binding?.forgotPassword?.setOnClickListener {
            //startActivity(Intent(this, ForgetPassword::class.java))
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
    }
    private fun signInUser()
    {
        val email = binding?.etEmail?.text.toString()
        val password = binding?.etPassword?.text.toString()
        if(validateForm(email, password))
        {
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful)
                    {
                        startActivity(Intent(this, HomeActivity::class.java))
                        finish()
                        hideProgressBar()
                    }else{
                        showToast(this, "Uanble to login! Please try again.")
                        hideProgressBar()
                    }
                }
        }
    }

    private fun validateForm(
        email: String,
        password: String
    ): Boolean
    {
        // Clear previous errors

        binding?.etEmail?.error = null
        binding?.etPassword?.error = null

        return when {
            TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding?.etEmail?.error = "Enter valid email address"
                false
            }
            TextUtils.isEmpty(password) -> {
                binding?.etPassword?.error = "Enter password"
                false
            }
            else -> true
        }
    }
}


