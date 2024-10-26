package com.example.custombroadcastreceiverapp

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {

    private lateinit var myReceiver: MyCustomBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myReceiver = MyCustomBroadcastReceiver()
        val sendBroadcastButton: Button = findViewById(R.id.sendBroadcastButton)

        sendBroadcastButton.setOnClickListener {
            // Create an intent with the custom action
            val intent = Intent("com.example.CUSTOM_ACTION")
            // Send the broadcast
            LocalBroadcastManager.getInstance(this)
                .sendBroadcast(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        // Register the receiver with the intent filter
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(myReceiver, IntentFilter("com.example.CUSTOM_ACTION"))
    }

    override fun onStop() {
        super.onStop()
        // Unregister the receiver to prevent memory leaks
        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(myReceiver)
    }

}