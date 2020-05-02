package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var database:FirebaseDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database= FirebaseDatabase.getInstance()



        SAVE.setOnClickListener {
            var firstName:String=firstname.text.toString()
            var secondName:String=secondname.text.toString()
            var emailaddress:String=EMAIL.text.toString()
            var phonenumber:String=phone.text.toString()
            saveUserDetails(
                userDetails(firstName,secondName,emailaddress,phonenumber)
            )

        }
        startActivity(Intent(this,DisplayUserDetailsActivity::class.java))


    }

    fun saveUserDetails(userDetails: userDetails){
        var databaseReference:DatabaseReference =database.getReference("userdetails")
        databaseReference.setValue(userDetails)
    }
}


