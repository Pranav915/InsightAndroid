package com.example.insights

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast.makeText as makeText1

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        val forgotBtn = findViewById<TextView>(R.id.tvForgotPassword)
        forgotBtn.setOnClickListener {
            startActivity(Intent(this@LoginPage,ForgotPasswordActivity::class.java))
            finish()
        }
        val loginBtn = findViewById<Button>(R.id.loginButton)
        loginBtn.setOnClickListener {
            val email = findViewById<EditText>(R.id.login_email_id).text.toString()
            val password = findViewById<EditText>(R.id.login_password).text.toString()
            //Login with firebase
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {task ->
                if(task.isSuccessful){
                    Toast.makeText(this@LoginPage,"You have been logged in.",Toast.LENGTH_SHORT).show()

                }
                else{
                    Toast.makeText(this@LoginPage,"Login Failed.",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}