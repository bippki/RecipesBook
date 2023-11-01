package com.medaedina.bookofrecipes.presentation.screen.detail

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.medaedina.bookofrecipes.data.remote.model.Meal
import com.medaedina.bookofrecipes.databinding.FragmentRecipeDetailsBinding
import com.medaedina.bookofrecipes.presentation.viewmodel.detail.RecipeDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Dagger Hilt для viewModel
@AndroidEntryPoint
class RecipeDetailsFragment : Fragment() {
    private var _binding: FragmentRecipeDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RecipeDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //инициализация
        _binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val meal = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable("meal", Meal::class.java)
        } else {
            requireArguments().getParcelable<Meal>("meal")
        }

        Glide.with(this).load(meal!!.strMealThumb).into(binding.imageViewIcon)
        //заполняем данные
        binding.textViewTitle.text = meal.strMeal

        binding.textViewInstructions.text = meal.strInstructions

        binding.buttonSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.saveMeal(meal)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}