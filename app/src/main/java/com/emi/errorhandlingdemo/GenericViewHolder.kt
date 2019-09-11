package com.emi.errorhandlingdemo

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class GenericViewHolder constructor(itemView : View) : RecyclerView.ViewHolder(itemView){

    abstract fun setDataOnView(position : Int)

}