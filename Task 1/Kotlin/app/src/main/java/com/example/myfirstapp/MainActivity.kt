package com.example.myfirstapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)
        val buttonNavigate: Button = findViewById(R.id.buttonNavigate)
        val buttonToast: Button = findViewById(R.id.buttonToast)

        button.setOnClickListener {
            textView.text = "Button Clicked!"
            textView.setTextColor(Color.RED)
        }

        buttonNavigate.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_MESSAGE", "Hello from MainActivity!")
            }
            startActivity(intent)
        }

        buttonToast.setOnClickListener {
            Toast.makeText(
                this,
                "Button was clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
