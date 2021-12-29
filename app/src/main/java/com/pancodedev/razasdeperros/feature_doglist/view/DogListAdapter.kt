package com.pancodedev.razasdeperros.feature_doglist.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pancodedev.razasdeperros.R
import com.pancodedev.razasdeperros.databinding.DogItemBinding
import com.pancodedev.razasdeperros.feature_doglist.model.data.Dog


/**
 * Adapter for the [RecyclerView] in [MainActivity].
 */
class DogListAdapter(private var dogListDataSet: List<Dog>):
    RecyclerView.Adapter<DogListAdapter.DogListViewHolder>() {

    /**
     * Provides a reference for the views needed to display items in your list.
     */
    inner class DogListViewHolder(binding: DogItemBinding): RecyclerView.ViewHolder(binding.root) {
        var imageViewDog = binding.imageviewDog

    }

    /**
     * Creates new views.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogListViewHolder {

        val binding = DogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogListViewHolder(binding)
    }

    /**
     * Returns DataSet size.
     */
    override fun getItemCount() = dogListDataSet.size

    /**
     * Replaces the content of an existing view with new data.
     */
    override fun onBindViewHolder(holder: DogListViewHolder, position:Int) {

        val post = dogListDataSet[position]
        holder.imageViewDog.load(post.imageLink)

    }

    /**
     * Changes current DataSet for a new one.
     */
    fun updateDataSet(newDataSet: List<Dog>) {
        dogListDataSet = newDataSet
        notifyDataSetChanged()
    }

}