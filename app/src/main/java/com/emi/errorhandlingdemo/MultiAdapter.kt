package com.emi.errorhandlingdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MultiAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var multiList = mutableListOf<String>()
    private var redList = mutableListOf<String>()
    companion object{
       const val LIST_ITEM_A = 0
       const val LIST_ITEM_B = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            LIST_ITEM_A -> MultiViewHolderA(inflater.inflate(R.layout.content_main_a, parent, false))
            LIST_ITEM_B -> MultiViewHolderB(inflater.inflate(R.layout.error_main_b, parent, false))
            else -> MultiViewHolderA(inflater.inflate(R.layout.content_main_a, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bluedata = multiList[position]
        val reddata = redList[position]
        return when(holder.itemViewType){
            LIST_ITEM_A ->{
                val holder1 : MultiViewHolderA = holder as MultiViewHolderA
                holder1.bind(bluedata)
            }

           LIST_ITEM_B ->{
               val holder2 : MultiViewHolderB = holder as MultiViewHolderB
               holder2.bind(reddata)
           }

          else -> return
        }
    }

    override fun getItemViewType(position: Int): Int {
       return if(position%2 == 0){
           LIST_ITEM_B
       }else{
           LIST_ITEM_A
       }
    }

    internal fun updateBlue(list : MutableList<String>){
        this.multiList = list
    }

    internal fun updateRed(list : MutableList<String>){
        this.redList = list

    }
    override fun getItemCount(): Int {
        return multiList.size+1
    }


    inner class MultiViewHolderA(itemView : View) : RecyclerView.ViewHolder(itemView){
        var test1 : TextView = itemView.findViewById(R.id.test_title)
         fun bind(title : String?){
             if(title != null){
                 test1.text = title
             }
         }
    }

    inner class MultiViewHolderB(itemView: View) : RecyclerView.ViewHolder(itemView){
        var test2 : TextView = itemView.findViewById(R.id.error_text)
        fun bind(error : String?){
            if(error != null){
                test2.text = error
            }
        }

    }
}