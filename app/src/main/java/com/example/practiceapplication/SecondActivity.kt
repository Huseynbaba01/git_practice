package com.example.practiceapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.practiceapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){
    lateinit var binding:ActivitySecondBinding
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second)
        binding.editText.setText(intent.getStringExtra("text"))
        binding.button.setOnClickListener {
            val intent:Intent = Intent(applicationContext,SecondActivity::class.java)
            startActivity(intent
                .putExtra("text",binding.editText.text.toString()))
        }



    }
}