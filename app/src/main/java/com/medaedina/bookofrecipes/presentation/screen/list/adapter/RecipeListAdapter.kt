package com.medaedina.bookofrecipes.presentation.screen.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.medaedina.bookofrecipes.data.remote.model.Meal
import com.medaedina.bookofrecipes.databinding.ItemMealBinding

class RecipeListAdapter(private val meals: List<Meal>) :
    RecyclerView.Adapter<RecipeListAdapter.MealViewHolder>() {

    //надо
    var onItemClick: ((Meal) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding = ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    inner class MealViewHolder(private val binding: ItemMealBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: Meal) {
            itemView.setOnClickListener {
                onItemClick?.invoke(meal)
            }
            binding.apply {
                textViewTitle.text = meal.strMeal
                Glide.with(this.root.context).load(meal.strMealThumb).into(imageViewIcon)
            }
        }
    }
}
