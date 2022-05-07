package com.example.threadapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.threadapp.R
import com.example.threadapp.databinding.RowLayoutBinding
import com.example.threadapp.model.User

class MainAdapter:RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
     private lateinit var users: List<User>
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    fun setUser(users: List<User>) {
         this.users = users


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
         val rowLayoutBinding = RowLayoutBinding.inflate(layoutInflater, parent, false);
       // val rowLayoutBinding: RowLayoutBinding =
            //DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewTypeToLayoutId[viewType] ?: 0,parent,false)
        return MyViewHolder(rowLayoutBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.rowLayoutBinding.user = users[position]
        Log.e(users.toString(),"MainAdapter")
        holder.rowLayoutBinding.executePendingBindings()
    }
    fun updateItems(users: List<User>?) {
        this.users = users ?: emptyList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {

        return users.size

    }




    class MyViewHolder(
        val rowLayoutBinding: RowLayoutBinding
        ) :
        RecyclerView.ViewHolder(rowLayoutBinding.root)


}

