package com.example.promptnowtest

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Text
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), RvAdapter.OnItemClickListener {
    private var rvAdapter = RvAdapter()
    val jsonArray = JSONArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.apply {
            var linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            isNestedScrollingEnabled = false
        }
        rvAdapter.context = this
        rvAdapter.onItemClickListener = this

        inputText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (s.toString() !== "") {
                    btn_add.setBackgroundColor(Color.parseColor("#e23425"))
                    btn_add.isClickable = true
                    btn_add.setEnabled(true)
                } else {
                    btn_add.setBackgroundColor(Color.parseColor("#50e23425"))
                    btn_add.isClickable = false
                    btn_add.setEnabled(false)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                btn_add.setBackgroundColor(Color.parseColor("#50e23425"))
                btn_add.isClickable = false
                btn_add.setEnabled(false)
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
        })
        btn_add.setOnClickListener {
            jsonArray.put(inputText.getText().toString())
            rvAdapter.datas = listOf(jsonArray)
            recyclerView.adapter = rvAdapter
        }

    }

    override fun onItemClick(position: Int) {
        jsonArray.getString(position)
    }
}