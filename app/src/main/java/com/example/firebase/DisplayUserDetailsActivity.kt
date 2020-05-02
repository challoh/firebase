package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*

class DisplayUserDetailsActivity : AppCompatActivity() {
   var database= FirebaseDatabase.getInstance()
    var databaseReference: DatabaseReference =database.getReference("userdetails")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_user_details)

        //get the data from firebase

    val dataListener=object:ValueEventListener{
        override fun onCancelled(p0: DatabaseError) {
        }

        override fun onDataChange(data: DataSnapshot) {
            //val userDetails=data.getValue(userDetails::class.java)

            Log.e("user Details","$data")
        }
    }
        databaseReference.addValueEventListener(dataListener)
    }
}
