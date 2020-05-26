package com.yum.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView

class RecyclerListAdapter(
    private val componentsList: ArrayList<Int>,
    val onClick: (Int, NavController) -> Unit,
    val navController: NavController
) : RecyclerView.Adapter<RecyclerListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = componentsList[position]
        holder.bindItems(itemModel, CustomOnClickListener(onClick, itemModel, navController))
        holder.itemView.findViewById<TextView>(R.id.list_item)
    }

    override fun getItemCount(): Int {
        return componentsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(content: Int, listener: View.OnClickListener) {
            val listItem = itemView.findViewById(R.id.list_item) as TextView
            listItem.text = itemView.context.getString(content)
            listItem.setOnClickListener(listener)
        }
    }

    class CustomOnClickListener(
        val onClick: (Int, NavController) -> Unit,
        val id: Int,
        val navController: NavController
    ) : View.OnClickListener {
        override fun onClick(v: View?) {
            onClick(id, navController)
        }
    }
}