package com.example.rickandmortyminiapp.fragments.one_char

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.rickandmortyminiapp.MainActivity
import com.example.rickandmortyminiapp.databinding.FragmentOneBinding
import com.example.rickandmortyminiapp.viewmodel.MainViewModel

class OneFragment : Fragment() {

    private lateinit var binding: FragmentOneBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        bindUI()

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun bindUI() = with(binding){
        (requireActivity() as MainActivity).supportActionBar?.title = viewModel.character!!.name
        txOneName.text = viewModel.character!!.name

        txOneSex.text = "Gender: ${viewModel.character!!.gender}"
        txOneSpecie.text = "Specie: ${viewModel.character!!.species}"
        txStatus.text = "Status: ${viewModel.character!!.status}"

        txLocation.text = "Last location:\n${viewModel.character!!.location.name}"
        txEpisodes.text = "Episodes:\n${viewModel.character!!.episode.size}"

        Glide.with(requireContext())
            .load(viewModel.character!!.image)
            .into(imOneChar)
    }

}