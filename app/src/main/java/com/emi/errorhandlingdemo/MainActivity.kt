package com.emi.errorhandlingdemo

import android.accounts.NetworkErrorException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpRetryException
import java.net.UnknownHostException

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MultiAdapter
    lateinit var layout : LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = LinearLayoutManager(this)
        adapter = MultiAdapter()
        rec_multi.layoutManager = layout
        rec_multi.adapter = adapter
        rec_multi.itemAnimator = DefaultItemAnimator()
        fetchData()
    }


    fun fetchData(){
        val dataSet = mutableListOf<String>()
        dataSet.add("first data")
        dataSet.add("second data")
        dataSet.add("third data")
        dataSet.add("fourth data")
        adapter.updateBlue(dataSet)

        val redData = mutableListOf<String>()
        redData.add("red data 1")
        redData.add("red data 2")
        redData.add("red data 3")
        redData.add("red data 4")
        adapter.updateRed(redData)
        /*
        for(items in 1..25){
           val error = getString(R.string.error_message)
            dataSet.add(error)
            adapter.updateMulti(dataSet)

        }

         */
    }

}
