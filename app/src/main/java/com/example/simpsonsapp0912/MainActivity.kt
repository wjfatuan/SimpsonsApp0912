package com.example.simpsonsapp0912

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        binding.charactersList.setOnItemClickListener { listView, view, index, vid ->
            Log.d("LISTMSG","listview: $listView ")
            Log.d("LISTMSG","view: $view ")
            Log.d("LISTMSG","index: $index ")
            Log.d("LISTMSG","vid: $vid ")
            val goToIntent = Intent(this, CharacterActivity::class.java)
            startActivity(goToIntent)
        }
    }
}