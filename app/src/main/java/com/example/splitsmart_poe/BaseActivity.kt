package com.example.splitsmart_poe

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

open class BaseActivity : AppCompatActivity() {
    private lateinit var pb: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    //displays progress bat
    fun showProgressBar()
    {
        pb = Dialog(this)
        pb.setContentView(R.layout.progress_bar)
        pb.setCancelable(false)
        pb.show()
    }
    //hides progress bar
    fun hideProgressBar()
    {
        pb.hide()
    }

    fun showToast(activity: Activity, msg:String)
    {
        Toast.makeText(activity, msg,Toast.LENGTH_SHORT).show()
    }
}
