package com.example.beers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beers.databinding.ItemBeerBinding
import com.example.beers.entities.Beer

class BeersAdapter(private val items: List<Beer>) :
    RecyclerView.Adapter<BeersAdapter.MyViewHolder>() {
    inner class MyViewHolder(b: ItemBeerBinding) : RecyclerView.ViewHolder(b.getRoot()) {
        var binding //Name of the test_list_item.xml in camel case + "Binding"
                : ItemBeerBinding

        init {
            binding = b
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //An example of how to use the bindings
        holder.binding.item = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
/*
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_beer, parent, false)

        return MyViewHolder(layout.rootView)*/
    }
}