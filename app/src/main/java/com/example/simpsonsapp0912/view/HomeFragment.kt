package com.example.simpsonsapp0912.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simpsonsapp0912.R
import com.example.simpsonsapp0912.databinding.FragmentHomeBinding
import com.example.simpsonsapp0912.model.HomeViewModel

class HomeFragment : Fragment() {

    var _viewmodel: HomeViewModel? = null
    private val viewmodel get() = _viewmodel!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("NAVIGATION","Hi, this is the home fragment")
        _viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewmodel.loadCharacters()
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater,container, false)
        val myAdapter = CharacterListAdapter(requireActivity(), viewmodel.simpsonsCharacters)
        binding.charactersList.adapter = myAdapter
        binding.charactersList.setOnItemClickListener { listView, view, index, vid ->
            Log.d("LISTMSG","listview: $listView ")
            Log.d("LISTMSG","view: $view ")
            Log.d("LISTMSG","index: $index ")
            Log.d("LISTMSG","vid: $vid ")
            viewmodel.selectCharacter(index)
            val params = Bundle()
            params.putInt("CHARACTERINDEX", index)
            params.putString("CHARACTERNAME", viewmodel.selectedCharacter.value)
            findNavController().navigate(R.id.action_homeFragment_to_characterDetailFragment, params)
            viewmodel.addCharacter("Maggie")
            myAdapter.notifyDataSetChanged()
        }

        return binding.root
    }
}