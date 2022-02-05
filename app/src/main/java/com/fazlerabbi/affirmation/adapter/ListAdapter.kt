package com.fazlerabbi.affirmation.adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fazlerabbi.affirmation.R
import com.fazlerabbi.affirmation.TodoUpadateCard
import com.fazlerabbi.affirmation.model.TodoCardInfo
import kotlinx.android.synthetic.main.todo_view.view.*
import java.util.*

class ListAdapter(var data:List<TodoCardInfo>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.title
        var priority = itemView.priority
        var layout = itemView.myLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.priority.text = data[position].priority

        when (data[position].priority.lowercase(Locale.getDefault())){
            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#5800FF"))

            "medium" -> holder.layout.setBackgroundColor(Color.parseColor("#E900FF"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#FFC600"))
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,TodoUpadateCard::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}