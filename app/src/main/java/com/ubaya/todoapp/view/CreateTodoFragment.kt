package com.ubaya.todoapp.view

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.ubaya.todoapp.R
import com.ubaya.todoapp.databinding.FragmentCreateTodoBinding
import com.ubaya.todoapp.model.Todo
import com.ubaya.todoapp.util.NotificationHelper
import com.ubaya.todoapp.util.TodoWorker
import com.ubaya.todoapp.viewmodel.DetailTodoViewModel
import kotlinx.android.synthetic.main.fragment_create_todo.*
import java.util.concurrent.TimeUnit

class CreateTodoFragment : Fragment() , TodoCreateLayoutInterface{
    private lateinit var viewModel: DetailTodoViewModel
    private lateinit var dataBinding: FragmentCreateTodoBinding

//    dipanggil sesaat setelah viewnya berhasil di load
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(DetailTodoViewModel::class.java)
    dataBinding.todo = Todo("","",3,0)
    viewModel = ViewModelProvider(this).get(DetailTodoViewModel::class.java)
    dataBinding.buttonListener = this
    dataBinding.radioListener = this


//        btnAdd.setOnClickListener {
////            NotificationHelper(view.context).createNotification("Todo Created", "A New todo has been created! Stay Focus!")
//            val myWorkRequest= OneTimeWorkRequestBuilder<TodoWorker>()
//                .setInitialDelay(30, TimeUnit.SECONDS)
//                .setInputData(workDataOf(
//                    "title" to "Todo Created",
//                    "message" to "A new todo has been created! Stay Focus!"))
//                .build()
//            WorkManager.getInstance(requireContext()).enqueue(myWorkRequest)
////            var radio =
////                view.findViewById<RadioButton>(radioGroupPriority.checkedRadioButtonId)
//            val radioGroup=view.findViewById<RadioGroup>(R.id.radioGroupPriority)
//            val radioButton=view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
//
//            var todo = Todo(txtTitle.text.toString(),
//                txtNotes.text.toString(), radioButton.tag.toString().toInt(), is_done = 0)
//            viewModel.addTodo(todo)
//            Toast.makeText(view.context, "Data added", Toast.LENGTH_SHORT).show()
//            Navigation.findNavController(it).popBackStack()
//
//
//
//
//        }
    }

//load layout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_create_todo, container, false)
        dataBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_create_todo,container,false)
    return dataBinding.root
    }

    override fun onRadiolick(v: View, priority: Int, obj: Todo) {
        TODO("Not yet implemented")
    }

    override fun onButtonAddClick(v: View) {
        TODO("Not yet implemented")
    }
}