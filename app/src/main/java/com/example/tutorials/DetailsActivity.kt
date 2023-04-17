package com.example.tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DetailsActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val firstBtn:Button = findViewById(R.id.btnFrag1)
        val secondBtn:Button = findViewById(R.id.btnFrag2)

        firstBtn.setOnClickListener{
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frameLayout, FirstFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        secondBtn.setOnClickListener{
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frameLayout, SecondFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }


}