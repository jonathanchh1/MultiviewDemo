package com.emi.errorhandlingdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DataBindAdapter : RecyclerView.Adapter<GenericViewHolder>(){


    companion object{
        const val viewType1 = 0
        const val viewType2 = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
       return when(viewType){
           viewType1 -> {
               val view = LayoutInflater.from(parent.context).inflate(R.layout.content_main_a, parent, false)
               return SectionViewHolder(view)
           }
           viewType2 ->{
               val view = LayoutInflater.from(parent.context).inflate(R.layout.error_main_b, parent, false)
               return SectionViewHolder(view)
           }
           else -> SectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.content_main_a, parent, false))
       }
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.setDataOnView(position)
    }

    override fun getItemViewType(position: Int): Int {
          return if(position == 0){
               viewType1
          }else{
                viewType2
          }
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
   inner class SectionViewHolder(itemView : View) : GenericViewHolder(itemView){

        override fun setDataOnView(position: Int) {

        }

    }



}