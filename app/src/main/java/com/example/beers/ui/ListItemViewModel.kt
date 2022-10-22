package com.example.beers.ui

abstract class ListItemViewModel{
    var adapterPosition: Int = -1
    var onListItemViewClickListener: GenericAdapter.OnListItemViewClickListener? = null
}