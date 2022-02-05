package com.fazlerabbi.affirmation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.fazlerabbi.affirmation.adapter.ListAdapter
import com.fazlerabbi.affirmation.data.TodoData
import kotlinx.android.synthetic.main.activity_todo_create_card.*
import kotlinx.android.synthetic.main.activity_todo_list.*

class TodoCreateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_create_card)

        todoSave.setOnClickListener {
            if (createTitle.text.toString().trim{it<=' '}.isNotEmpty()
                && createPriority.text.toString().trim{it<=' '}.isNotEmpty() ){
                var title = createTitle.getText().toString()
                var  priority = createPriority.getText().toString()
                TodoData.setData(title,priority)

                Toast.makeText(this,TodoData.size().toString(),Toast.LENGTH_LONG).show()
                startActivity(Intent(this,Todo_list::class.java))
            }
        }

    }
}