package com.example.practiceapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.practiceapplication.ViewModelClasses.MainActivityViewModel
import com.example.practiceapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel:MainActivityViewModel
    lateinit var button: Button
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.editText.setText(intent.getStringExtra("text"))
        button = binding.button
        button.setOnClickListener {
            val intent:Intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent
                .putExtra("text",binding.editText.text.toString()))
        }




        val textView = findViewById<TextView>(R.id.text)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.currentText.observe(this, Observer {

        })
// ...
/*
// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://projects.vishnusivadas.com/testing/read.php"

        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    textView.text = "Response is: $response"
                },
                Response.ErrorListener { textView.text = "That didn't work!" })

// Add the request to the RequestQueue.
        queue.add(stringRequest)*/
    }
}