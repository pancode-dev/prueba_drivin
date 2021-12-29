package com.pancodedev.razasdeperros.feature_doglist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.pancodedev.razasdeperros.R
import com.pancodedev.razasdeperros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val tag = this::class.simpleName
    private lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DogListAdapter(listOf())
        binding.recyclerviewDogList.apply {
            this.adapter = adapter
            layoutManager = GridLayoutManager(this@MainActivity,2, GridLayoutManager.VERTICAL, false)
        }

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getDogList().observe(this, {
            adapter.updateDataSet(it)
        })

        viewModel.getBreedList().observe(this, {

            if(it.size > 8) viewModel.fetchDogImagesFromServer(it.subList(0,6))
        })

        viewModel.fetchBreedListFromServer()
    }
}