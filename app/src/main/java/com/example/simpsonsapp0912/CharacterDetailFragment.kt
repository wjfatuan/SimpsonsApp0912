package com.example.simpsonsapp0912

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.simpsonsapp0912.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    //val args: CharacterDetailFragmentArgs by navArgs()
    var name: String? = "Bart"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("NAVIGATION","Hi, this is the character detail fragment")
        val binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        binding.characterName.text = name
        val id = resources.getIdentifier(name?.lowercase(), "drawable", requireActivity().packageName)
        binding.characterImage.setImageResource(id)

        binding.btnDoSomething.setOnClickListener {
            callIntent()
        }
        return binding.root
    }

    fun callIntent() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://es.wikipedia.org/w/index.php?search=$name")
        }
        startActivity(intent)
    }

}