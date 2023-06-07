package com.ubaya.todoapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.todoapp.R
import com.ubaya.todoapp.databinding.TodoItemLayoutBinding
import com.ubaya.todoapp.model.Todo
import kotlinx.android.synthetic.main.todo_item_layout.view.*

class TodoListAdapter(val todos:ArrayList<Todo>,val adapterOnClick : (Todo) -> Unit)
    : RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>(),TodoItemLayoutInterface {
    class TodoListViewHolder(var view: TodoItemLayoutBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.todo_item_layout, parent, false)
//        return TodoListViewHolder(view)
        val view=TodoItemLayoutBinding.inflate(inflater,parent,false)
        return TodoListViewHolder(view)

    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
//       todo dari variabel todo di ui
        holder.view.todo=todos[position]
        holder.view.checkListener=this
        holder.view.editListener=this

        holder.view.checkTask.isChecked=false

//        holder.view.checkTask.setText(todos[position].title.toString())
//        holder.view.checkTask.isChecked=false
//
//        holder.view.checkTask.setOnCheckedChangeListener { compoundButton, isChecked ->
//            if(isChecked){
//                adapterOnClick(todos[position])
//            }
//        }
//        holder.view.imgEdit.setOnClickListener(){
//            val action = TodoListFragmentDirections.actionEditTodoFragment(todos[position].uuid)
//            Navigation.findNavController(it).navigate(action)
//        }


    }

    override fun getItemCount(): Int {
        return todos.size
    }
    fun updateTodoList(newTodoList: List<Todo>) {
        todos.clear()
        todos.addAll(newTodoList)
        notifyDataSetChanged()
    }

    override fun onCheckedChange(cb: CompoundButton, isChecked: Boolean, obj: Todo) {
        if(isChecked){
                adapterOnClick(obj)
            }
    }

    override fun onTodoEditClick(v: View) {
        val uuid=v.tag.toString().toInt()
        val action = TodoListFragmentDirections.actionEditTodoFragment(v.tag.toString().toInt())
          Navigation.findNavController(v).navigate(action)
    }

}

