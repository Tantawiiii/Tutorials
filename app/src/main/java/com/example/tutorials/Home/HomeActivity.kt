package com.example.tutorials.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorials.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val edtTodes:EditText = findViewById(R.id.edtTodes)
        val addNote:Button = findViewById(R.id.btnAddNote)
        val rvTodes:RecyclerView = findViewById(R.id.rvTodes)


        var todosList = mutableListOf(
            Todo("Follow Android Devs",false),
            Todo("Learn More About me",true),
            Todo("Follow Ahmed Ramadan",false),
            Todo("Follow Android Devs",false),
            Todo("Follow Android Devs",true),
            Todo("Follow Android Devs",true),
            Todo("Follow Android Devs",false),
            Todo("Follow Android Devs",true)
        )

        val adapter = TodoAdapter(todosList)
        rvTodes.adapter = adapter
        rvTodes.layoutManager = LinearLayoutManager(this)

        addNote.setOnClickListener{

            val title = edtTodes.text.toString()
            val todo  = Todo(title,false)
            todosList.add(todo)
            adapter.notifyItemInserted(todosList.size-1)
        }
    }
}
