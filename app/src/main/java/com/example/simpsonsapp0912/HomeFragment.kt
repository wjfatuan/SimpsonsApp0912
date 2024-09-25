package com.example.simpsonsapp0912

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simpsonsapp0912.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    val simpsonsCharacters = arrayListOf("Marge", "Lisa", "Homer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("NAVIGATION","Hi, this is the home fragment")
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater,container, false)
        val myAdapter = CharacterListAdapter(requireActivity(), simpsonsCharacters)
        binding.charactersList.adapter = myAdapter
        binding.charactersList.setOnItemClickListener { listView, view, index, vid ->
            Log.d("LISTMSG","listview: $listView ")
            Log.d("LISTMSG","view: $view ")
            Log.d("LISTMSG","index: $index ")
            Log.d("LISTMSG","vid: $vid ")
            val params = Bundle()
            params.putInt("CHARACTERINDEX", index)
            params.putString("CHARACTERNAME", simpsonsCharacters[index])
            findNavController().navigate(R.id.action_homeFragment_to_characterDetailFragment, params)
            simpsonsCharacters.add("Maggie")
            myAdapter.notifyDataSetChanged()
        }

        return binding.root
    }
}