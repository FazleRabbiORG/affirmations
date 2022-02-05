package com.fazlerabbi.affirmation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fazlerabbi.affirmation.data.TodoData
import kotlinx.android.synthetic.main.activity_todo_upadate_card.*

class TodoUpadateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_upadate_card)
        val pos = intent.getIntExtra("id", -1)
        if (pos != -1){
            val title = TodoData.getData(pos).title
            val priority = TodoData.getData(pos).priority
            updateTitle.setText(title)
            updatePriority.setText(priority)

            todoUpdateBtn.setOnClickListener {
                TodoData.updateData(pos,updateTitle.text.toString(),updatePriority.text.toString())
                startActivity(Intent(this,Todo_list::class.java))
            }

            todoDeleteBtn.setOnClickListener {
                TodoData.deleteData(pos)
                Toast.makeText(this,"data deleted",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,Todo_list::class.java))
            }
        }
    }
}