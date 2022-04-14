package com.example.rickandmortyminiapp.fragments.all_chars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyminiapp.MainActivity
import com.example.rickandmortyminiapp.api.retrofit.model.AllCharsModel
import com.example.rickandmortyminiapp.databinding.FragmentAllBinding
import com.example.rickandmortyminiapp.fragments.all_chars.adapter.CharsAdapter
import com.example.rickandmortyminiapp.viewmodel.MainViewModel
import retrofit2.Response

class AllFragment : Fragment() {

    private lateinit var binding: FragmentAllBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        bindObservers()

        return binding.root
    }

    private fun bindObservers() {
        viewModel.getChars()
        viewModel.allChars.observe(viewLifecycleOwner){ response ->
            bindRcView(response!!)
        }
    }

    private fun bindRcView(response: Response<AllCharsModel>) {
        if(response.isSuccessful){
            binding.rcAll.apply {
                adapter = CharsAdapter(response.body()!!, requireContext(), (requireActivity() as MainActivity).navController, viewModel)
                layoutManager = LinearLayoutManager(requireContext())
            }
        } else {
            Toast.makeText(requireContext(), "Some problem!", Toast.LENGTH_LONG).show()
        }
    }

}