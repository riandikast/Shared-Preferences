package com.binar.sharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class HomeActivity : AppCompatActivity() {
    lateinit var get : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        get = getSharedPreferences("login", Context.MODE_PRIVATE)
        val username = get.getString("username", "")
        viewusername.text = "Hello " +username

        btnlogout.setOnClickListener {


            val custom = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null,)

            val a = AlertDialog.Builder(this)
                .setView(custom)
                .create()

            custom.btntidak.setOnClickListener {


                a.dismiss()
            }
            custom.btnya.setOnClickListener {
                val logout =  get.edit()
                logout.clear()
                logout.apply()

                startActivity(Intent(this, MainActivity::class.java)  )

                a.dismiss()
            }
            a.show()
        }
    }
}