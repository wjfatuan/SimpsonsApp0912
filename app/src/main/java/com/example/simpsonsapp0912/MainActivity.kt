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

    val simpsonsCharacters = arrayListOf("Marge", "Lisa", "Homer")

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

        val myAdapter = CharacterListAdapter(this, simpsonsCharacters)
        binding.charactersList.adapter = myAdapter

        binding.charactersList.setOnItemClickListener { listView, view, index, vid ->
            Log.d("LISTMSG","listview: $listView ")
            Log.d("LISTMSG","view: $view ")
            Log.d("LISTMSG","index: $index ")
            Log.d("LISTMSG","vid: $vid ")
            val goToIntent = Intent(this, CharacterActivity::class.java)
            goToIntent.putExtra("CHARACTERINDEX", index)
            goToIntent.putExtra("CHARACTERNAME", simpsonsCharacters[index])
            simpsonsCharacters.add("Maggie")
            myAdapter.notifyDataSetChanged()
            startActivity(goToIntent)
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

