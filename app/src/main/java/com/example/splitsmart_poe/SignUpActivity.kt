package com.example.splitsmart_poe

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import com.example.splitsmart_poe.databinding.ActivitySignupBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class SignUpActivity : BaseActivity() {

    private var binding: ActivitySignupBinding? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = Firebase.auth

//Add setOnClick Listener
        binding?.signupButton?.setOnClickListener { registerUser() }
    }
        // Handles user registration
        private fun registerUser() {
            val name = binding?.nameInput?.text.toString()
            val email = binding?.signupEmail?.text.toString()
            val password = binding?.signupPassword?.text.toString()
            val confirmPasssword = binding?.confirmPassword?.text.toString()

            if (validateForm(name, email, password, confirmPasssword)) {
                showProgressBar()
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            showToast(this, "User registered successfully!")
                            hideProgressBar()
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        } else {
                            showToast(this, "User registration failed!")
                            hideProgressBar()
                        }
                    }
            }
        }

    private fun validateForm(
        name: String,
        email: String,
        password: String,
        confirmPasssword: String
    ): Boolean {
        // Clear previous errors
        binding?.nameInput?.error = null
        binding?.signupEmail?.error = null
        binding?.signupPassword?.error = null
        binding?.confirmPassword?.error = null

        return when {
            TextUtils.isEmpty(name) -> {
                binding?.nameInput?.error = "Enter name"
                false
            }
            TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding?.signupEmail?.error = "Enter valid email address"
                false
            }
            TextUtils.isEmpty(password) -> {
                binding?.signupPassword?.error = "Enter password"
                false
            }
            password != confirmPasssword -> {
                binding?.confirmPassword?.error = "Passwords do not match"
                false
            }
            else -> true
        }
    }
}


