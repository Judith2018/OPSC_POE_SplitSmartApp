package com.example.splitsmart_poe

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import com.example.splitsmart_poe.databinding.ActivityForgetPasswordBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ForgetPasswordActivity : BaseActivity() {

    private var binding: ActivityForgetPasswordBinding? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        auth = Firebase.auth
    }

    private fun validateForm(email: String):Boolean{
        return when {
            TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding?.tilEmailForgetPassword?.error = "Enter valid email address"
                false
            }else -> true
        }
    }
    private fun resetPassword(){
      val email = binding?.etForgotPasswordEmail?.text.toString()
        if(validateForm(email))
        {
            showProgressBar()
            auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if(task.isSuccessful)
                {
                    hideProgressBar()
                    binding?.tilEmailForgetPassword?.visibility = View.GONE
                    binding?.tvSubmitMsg?.visibility = View.VISIBLE
                    binding?. btnForgotPasswordSubmit?.visibility = View.GONE
                }
                else
                {
                    hideProgressBar()
                    showToast(this, "Password reset failed! Please try again.")
                }
            }
        }
    }
}