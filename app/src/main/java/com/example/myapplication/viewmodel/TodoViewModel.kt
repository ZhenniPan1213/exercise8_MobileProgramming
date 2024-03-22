package com.example.myapplication.viewmodel

import com.example.myapplication.model.TodosApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.example.myapplication.model.Todo

class TodoViewModel : ViewModel() {
        var todos = mutableStateListOf<Todo>()
                private set

        init {
            getTodosList()
        }

       private fun getTodosList() {
                viewModelScope.launch {
                        var todosApi: TodosApi? = null
                        try {
                                todosApi = TodosApi.getInstance()
                                todos.clear()
                                todos.addAll(todosApi.getTodos())
                        } catch (e: Exception) {
                                Log.d("TODOVIEWMODEL", e.message.toString())
                        }
                }
        }
}