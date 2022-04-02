package com.binar.sharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var send : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if ((getSharedPreferences("login", Context.MODE_PRIVATE).contains("username"))
        && (getSharedPreferences("login", Context.MODE_PRIVATE).contains("password"))){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()

        }
        send = getSharedPreferences("login", Context.MODE_PRIVATE)
        sf()

    }

    fun sf(){
        btnlogin.setOnClickListener{
            val user = screenusername.text.toString()
            val pass = screenpassword.text.toString()

            if (user == "andika" && pass == "1") {

                val sf = send.edit()
                sf.putString("username", user)
                sf.putString("password", pass)
                sf.apply()
                startActivity(Intent(this, HomeActivity::class.java))

            }else{
                val text = "Username atau password salah!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, text, duration)

                val text1 = toast.getView()?.findViewById(android.R.id.message) as TextView
                val toastView: View? = toast.getView()
                toastView?.setBackgroundColor(Color.TRANSPARENT)
                text1.setTextColor(Color.RED);
                text1.setTextSize(18F)
                toast.show()

                toast.setGravity(Gravity.CENTER or Gravity.TOP, 0, 820)

            }


        }
}}