package com.ubaya.todoapp.util

import android.content.Context
import androidx.room.Room
import com.ubaya.todoapp.model.TodoDatabase

val DB_NAME="todoDB"

fun buildDb(context: Context): TodoDatabase {
    val db = Room.databaseBuilder(context, TodoDatabase::class.java, DB_NAME).build()
    return db
}
