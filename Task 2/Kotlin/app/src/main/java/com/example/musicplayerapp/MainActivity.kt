package com.example.musicplayerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startMusicButton = findViewById<Button>(R.id.startMusicButton)
        val stopMusicButton = findViewById<Button>(R.id.stopMusicButton)

        startMusicButton.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            startService(intent) // Start the foreground service
        }

        stopMusicButton.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            stopService(intent) // Stop the foreground service
        }
    }
}