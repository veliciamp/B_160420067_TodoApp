package com.ubaya.todoapp.view

import android.view.View
import android.widget.CompoundButton
import com.ubaya.todoapp.model.Todo

//bikinnya dari kotlin class file trs FILE BUKAN INTERFACE
//kalo di slide 1 interface 1 function and it's a nono
//kalo di slide namanya jelek, jadi namanya tergantung uinya

interface TodoItemLayoutInterface{
    fun onCheckedChange(cb:CompoundButton, isChecked:Boolean, obj: Todo)

    fun onTodoEditClick(v: View)
}