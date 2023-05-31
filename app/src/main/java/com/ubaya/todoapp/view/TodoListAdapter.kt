package com.ubaya.todoapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.todoapp.R
import com.ubaya.todoapp.model.Todo
import kotlinx.android.synthetic.main.todo_item_layout.view.*

class TodoListAdapter(val todos:ArrayList<Todo>,val adapterOnClick : (Todo) -> Unit)
    : RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>() {
    class TodoListViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.todo_item_layout, parent, false)

        return TodoListViewHolder(view)

    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.view.checkTask.setText(todos[position].title.toString())
        holder.view.checkTask.isChecked=false

        holder.view.checkTask.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                adapterOnClick(todos[position])
            }
        }
        holder.view.imgEdit.setOnClickListener(){
            val action = TodoListFragmentDirections.actionEditTodoFragment(todos[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return todos.size
    }
    fun updateTodoList(newTodoList: List<Todo>) {
        todos.clear()
        todos.addAll(newTodoList)
        notifyDataSetChanged()
    }

}

