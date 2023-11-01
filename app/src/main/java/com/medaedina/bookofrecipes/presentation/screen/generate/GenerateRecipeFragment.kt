package com.medaedina.bookofrecipes.presentation.screen.generate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.medaedina.bookofrecipes.databinding.FragmentGenerateRecipeBinding
import com.medaedina.bookofrecipes.presentation.viewmodel.generate.GenerateRecipeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GenerateRecipeFragment : Fragment() {
    private var _binding: FragmentGenerateRecipeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<GenerateRecipeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenerateRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGenerate.setOnClickListener {
            lifecycleScope.launch {
                viewModel.generateRecipe(binding.textInputEditTextIngredients.text.toString())
            }
        }

        viewModel.mealLiveData.observe(viewLifecycleOwner) { result ->
            if (result == null) {
                Toast.makeText(
                    requireContext(),
                    "Not found",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                findNavController().navigate(GenerateRecipeFragmentDirections.actionGenerateRecipeFragmentToRecipeDetailsFragment(result))
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}