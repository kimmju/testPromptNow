package com.example.promptnowtest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import kotlin.properties.Delegates

class RvAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var datas by Delegates.observable(listOf<JSONArray>()) { _, _, _ ->
        notifyDataSetChanged()
    }
    var context: Context? = null
    var onItemClickListener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return RvViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var rvViewHolder = holder as RvViewHolder
        var data = datas[position]
        print(data)
        rvViewHolder.txView.text = data.getString(position)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}