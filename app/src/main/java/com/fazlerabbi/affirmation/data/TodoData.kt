package com.fazlerabbi.affirmation.data

import com.fazlerabbi.affirmation.model.TodoCardInfo

object TodoData {
    var listData = mutableListOf<TodoCardInfo>()

    fun setData(title: String, priority: String) {
        listData.add(TodoCardInfo(title, priority))
    }

    fun getAllData(): List<TodoCardInfo> {
        return listData
    }

    fun deleteAllData() {
        listData.clear()
    }

    fun getData(pos: Int): TodoCardInfo {
        return listData[pos]
    }

    fun updateData(pos: Int, title: String, priority: String) {
        listData[pos].title = title
        listData[pos].priority = priority
    }

    fun deleteData(pos:Int){
        listData.removeAt(pos)
    }
    fun size(): Int {
        return listData.size
    }
}