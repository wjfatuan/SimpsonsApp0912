package com.example.simpsonsapp0912

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simpsonsapp0912.databinding.FragmentCatsBinding
import com.example.simpsonsapp0912.model.CatsViewModel
import com.example.simpsonsapp0912.services.Cat
import com.example.simpsonsapp0912.services.CatsApi
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.koushikdutta.async.future.FutureCallback
import com.koushikdutta.ion.Ion
import com.squareup.picasso.Picasso
import java.lang.Exception

class CatsFragment : Fragment() {

    var _binding : FragmentCatsBinding? = null
    val binding get() = _binding!!

    companion object {
        fun newInstance() = CatsFragment()
    }

    private val viewModel: CatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showCat(cat: Cat) {
        Picasso.get()
            .load(cat.url)
            .into(binding.catImage)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatsBinding.inflate(layoutInflater)
        viewModel.loadCats()
        viewModel.cat.observe(viewLifecycleOwner) {
            showCat(it)
        }
        binding.btnRefresh.setOnClickListener {
            viewModel.loadCats()
        }
        return binding.root
    }
}