package com.example.rickandmortyminiapp.fragments.all_chars.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyminiapp.R
import com.example.rickandmortyminiapp.api.retrofit.model.AllCharsModel
import com.example.rickandmortyminiapp.api.retrofit.model.Result
import com.example.rickandmortyminiapp.databinding.ItemCharacterBinding
import com.example.rickandmortyminiapp.viewmodel.MainViewModel

class CharsAdapter(
    chars: AllCharsModel,
    private val context: Context,
    private val navController: NavController,
    private val viewModel: MainViewModel
) : RecyclerView.Adapter<CharsAdapter.ItemViewHolder>() {

    private var charsList = chars

    class ItemViewHolder(private val binding: ItemCharacterBinding)
        : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(
            result: Result,
            context: Context,
            navController: NavController,
            viewModel: MainViewModel
        ) = with(binding){
            txName.text = result.name
            txRace.text = "Specie: ${result.species}"
            txSex.text ="Gender: ${result.gender}"

            Glide.with(context)
                .load(result.image)
                .centerCrop()
                .into(imChar)

            characterLayout.setOnClickListener {
                viewModel.character = result
                navController.navigate(R.id.oneFragment)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemCharacterBinding
            .inflate(LayoutInflater
                .from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = charsList.results[position]
        holder.bind(item, context, navController, viewModel)
    }

    override fun getItemCount(): Int {
        return charsList.results.size
    }

//    @SuppressLint("NotifyDataSetChanged")
//    fun setNewData(chars: AllCharsModel){
//        charsList = chars
//        notifyDataSetChanged()
//    }

}