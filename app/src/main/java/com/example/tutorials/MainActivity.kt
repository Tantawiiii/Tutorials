package com.example.tutorials


import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import com.example.tutorials.Home.HomeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Go to Home Activity
        val goHome:Button = findViewById(R.id.btnGoHome)
        goHome.setOnClickListener {
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
        }

        //Go to Details Activity == Fragment
        val goDetails:Button = findViewById(R.id.btnGoDetails)
        goDetails.setOnClickListener {
            startActivity(Intent(this@MainActivity, DetailsActivity::class.java))
        }

        //Spinner Created
        val spinMonth: Spinner = findViewById(R.id.spMonths)

        /** custom list added
        val customList = listOf("First","Second","Third","Fourth")
        val adapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,customList)
        spinMonth.adapter = adapter
         */

        spinMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                adapterView:AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity
                    , "You Selected ${adapterView?.getItemAtPosition(position).toString()}"
                    ,Toast.LENGTH_LONG).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        // Create An Alert Dialog ....
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you need to add a rmdanii to Your Content list ..")
            .setIcon(R.drawable.ic_person_add)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(
                    this,
                    "Do will add a rmdanii to Your Content list .. ",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(
                    this,
                    "you don't add a rmdanii to Your Content list .. ",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()

        var btnDialog1: Button = findViewById(R.id.btnDialog1)
        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        // Create An radio box  Dialog ....
        val option = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("choose one of them options")
            .setSingleChoiceItems(option, 0) { _, i ->
                Toast.makeText(this, "Yu clicked now on ${option[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "you accepted the Single Choice Items ", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "you decline the Single Choice Items ", Toast.LENGTH_SHORT)
                    .show()
            }.create()

        var btnDialog2: Button = findViewById(R.id.btnDialog2)
        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        //Take photo from our device
        var takePhoto: Button = findViewById(R.id.btnTakePhoto)
        takePhoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
            }
        }

        // Create An Checked box  Dialog ....
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("choose one of these options:")
            .setMultiChoiceItems(option, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You checked ${option[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You Unchecked ${option[i]}", Toast.LENGTH_SHORT).show()
                }

            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "you accepted the Multi Choice Items ", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "you decline the Multi Choice Items ", Toast.LENGTH_SHORT)
                    .show()
            }.create()

        var btnDialog3: Button = findViewById(R.id.btnDialog3)
        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }

    }

    //Create Toolbar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.idSports -> Toast.makeText(this, "Make Your Sports Here", Toast.LENGTH_SHORT)
                .show()
            R.id.idFav -> Toast.makeText(
                this,
                "Make Your Favorites Sports Here",
                Toast.LENGTH_SHORT
            ).show()
            R.id.idSetting -> Toast.makeText(this, "Make Your Setting Here", Toast.LENGTH_SHORT)
                .show()
            R.id.idFeedback -> Toast.makeText(this, "Make Your Feedback Here", Toast.LENGTH_SHORT)
                .show()
            R.id.idCloseApp -> finish()
        }

        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            var photoImg: ImageView = findViewById(R.id.ivPhoto)
            val uri = data?.data
            photoImg.setImageURI(uri)
        }

    }


}