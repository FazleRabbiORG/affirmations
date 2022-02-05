package com.fazlerabbi.affirmation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.fazlerabbi.affirmation.adapter.ListAdapter
import com.fazlerabbi.affirmation.data.TodoData
import kotlinx.android.synthetic.main.activity_todo_list.*

class Todo_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)

        todoAdd.setOnClickListener{
            val intent = Intent(this,TodoCreateCard::class.java)
            startActivity(intent)
        }

        todoDeleteAll.setOnClickListener{
            TodoData.deleteAllData()
            TodoData.getAllData()
            resetRecyclerView()
        }

        taskFilter.setOnClickListener{
            showDialog()
        }

        resetRecyclerView()

    }

    private fun resetRecyclerView() {
        todo_recycler_view.adapter = ListAdapter(TodoData.getAllData())
        todo_recycler_view.layoutManager = LinearLayoutManager(this)
        Toast.makeText(this, " size ${ TodoData.size().toString() }",Toast.LENGTH_LONG).show()
    }

    private fun showDialog(){
        // Late initialize an alert dialog object
        lateinit var dialog: AlertDialog

        // Initialize an array of colors
        val arrayColors = arrayOf("RED","GREEN","YELLOW","BLACK","MAGENTA","PINK")

        // Initialize a boolean array of checked items
        val arrayChecked = booleanArrayOf(false,false,false,false,false,false)


        // Initialize a new instance of alert dialog builder object
        val builder = AlertDialog.Builder(this)

        // Set a title for alert dialog
        builder.setTitle("Choose favorite colors.")


        // Define multiple choice items for alert dialog
        builder.setMultiChoiceItems(arrayColors, arrayChecked) { dialog, which, isChecked ->
            // Update the clicked item checked status
            arrayChecked[which] = isChecked

            // Get the clicked item
            val color = arrayColors[which]

            // Display the clicked item text

            Toast.makeText(this, "$color clicked.", Toast.LENGTH_LONG)
        }


        // Set the positive/yes button click listener
        builder.setPositiveButton("OK") { _, _ ->
            // Do something when click positive button

            var checkedThat :String =""
            for (i in arrayColors.indices) {
                val checked = arrayChecked[i]
                if (checked) {
                   checkedThat = checked.toString()
                }
            }
            Toast.makeText(this,"selected $checkedThat",Toast.LENGTH_LONG)

        }


        // Initialize the AlertDialog using builder object
        dialog = builder.create()

        // Finally, display the alert dialog
        dialog.show()
    }
}
