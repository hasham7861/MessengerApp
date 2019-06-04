package com.example.messengerapp
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);

        login_button_login.setOnClickListener {

        }


        back_to_register_textview.setOnClickListener {

//            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(intent)
            finish()

        }

    }

    private fun performLogin(){

        val email = email_edittext_login.text.toString()
        val password = password_edittext_login.text.toString()

        Log.d("LoginActivity","Email: $email")
        Log.d("LoginActivity","Password: $password")

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please enter text in email with password", Toast.LENGTH_SHORT).show()
            return
        }
        // Authentication to create user with given info
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                // else if successful
                Log.d("Login","Successfully logged in : ${it.result?.user?.uid}")
            }
            .addOnFailureListener{
                Log.d("Login","Can't login in : ${it.message}")
            }

    }
}