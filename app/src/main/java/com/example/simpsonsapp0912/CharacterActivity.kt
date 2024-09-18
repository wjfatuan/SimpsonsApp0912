package com.example.simpsonsapp0912

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simpsonsapp0912.databinding.ActivityCharacterBinding

class CharacterActivity : AppCompatActivity() {

    var name: String? = "Bart"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCharacterBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val index = intent.getIntExtra("CHARACTERINDEX", -1)
        name = intent.getStringExtra("CHARACTERNAME")
        binding.characterName.text = name
        val id = resources.getIdentifier(name?.lowercase(), "drawable", packageName)
        binding.characterImage.setImageResource(id)

        binding.btnDoSomething.setOnClickListener {
            callIntent()
        }
    }

    fun callIntent() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://es.wikipedia.org/w/index.php?search=$name")
        }
        startActivity(intent)
    }

    /**
     * URL: Uniform Resource Locator (Una URL es una URI)
     * ejemplos:
     * http://www.google.com
     *
     * URI: Uniform Resource Identifier
     * schema:id
     * ejemplos:
     * tel:5555555
     * geo:48.8580852,2.2925508
     * email:thom@gmail.com
     * http://servidor/ruta
     */




}