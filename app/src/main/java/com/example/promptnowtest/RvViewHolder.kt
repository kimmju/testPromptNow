package com.example.promptnowtest

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class RvViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    var txView : TextView = view.findViewById(R.id.tx_Item)
    fun bindData(datas : JSONObject){
        txView
    }
}