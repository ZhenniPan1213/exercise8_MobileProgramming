package com.example.myapplication.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import  retrofit2.http.GET

const val BASE_URL="https://jsonplaceholder.typicode.com/"

interface  TodosApi{
    @GET("todos")
    suspend fun getTodos(): List<Todo>


    companion object{
        var todoService: TodosApi?=null

        fun getInstance(): TodosApi{
            if (todoService===null ){
                todoService= Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
            }
            return todoService!!
        }
    }
}

data class Todo(
    //@SerializedName("userId") var uID: Int,
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)
