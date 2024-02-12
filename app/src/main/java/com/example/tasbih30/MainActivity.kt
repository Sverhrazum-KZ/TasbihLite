package com.example.tasbih30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<TextView>(R.id.count_text)
        val increaseButton = findViewById<Button>(R.id.count_btn)
        val clearButton = findViewById<Button>(R.id.clear_btn)

        suspend fun increaseCounter() {
            val currentValue = editText.text.toString().toInt()
            val newValue = currentValue + 1
            withContext(Dispatchers.Main) {
                editText.setText(newValue.toString())
            }
        }

        suspend fun clearCounter() {
            withContext(Dispatchers.Main){
                editText.setText("0")
            }
        }

clearButton.setOnClickListener {
    GlobalScope.launch {
        clearCounter()
    }
}

        increaseButton.setOnClickListener {
            GlobalScope.launch {
                increaseCounter()
            }
        }
    }
}

