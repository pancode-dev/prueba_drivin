package com.pancodedev.razasdeperros.feature_doglist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.pancodedev.razasdeperros.R

class MainActivity : AppCompatActivity() {
    private val tag = this::class.simpleName
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getBreedList().observe(this, { list ->
            list.forEach {
                Log.d(tag, "${it.first} - ${it.second}")
            }
        })

        viewModel.fetchBreedListFromServer()
    }
}