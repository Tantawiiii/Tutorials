package com.example.tutorials


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var takePhoto: Button = findViewById(R.id.btnTakePhoto)
        var photoImg: ImageView = findViewById(R.id.ivPhoto)

        takePhoto.setOnClickListener{
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it,0)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0){
            var photoImg: ImageView = findViewById(R.id.ivPhoto)
            val uri = data?.data
            photoImg.setImageURI(uri)
        }

    }


}