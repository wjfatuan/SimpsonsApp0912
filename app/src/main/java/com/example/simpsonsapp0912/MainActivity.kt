package com.example.simpsonsapp0912

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simpsonsapp0912.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        Log.d("LIFECYCLE", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "on destroy")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "on start")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "on stop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "on pause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "on resume")
    }
}

/**
 * persistencia
 */

