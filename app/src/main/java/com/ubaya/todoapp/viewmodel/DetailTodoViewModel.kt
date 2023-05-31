package com.ubaya.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.ubaya.todoapp.model.Todo
import com.ubaya.todoapp.model.TodoDatabase
import com.ubaya.todoapp.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get
import kotlin.coroutines.CoroutineContext

class DetailTodoViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    val todoLD= MutableLiveData<Todo>()
    private val job = Job()

    fun addTodo(todo:Todo) {
        launch {
            val db = buildDb(getApplication())
//            val db = Room.databaseBuilder(
//                getApplication(), TodoDatabase::class.java,
//                "newtododb"
//            ).build()
            db.todoDao().insertAll(todo)
        }

    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun fetch(uuid:Int) {
        launch {
            val db = buildDb(getApplication())
//            todoLD.value =  db.todoDao().selectTodo(uuid)
            todoLD.postValue(db.todoDao().selectTodo(uuid))
        }
    }

}

