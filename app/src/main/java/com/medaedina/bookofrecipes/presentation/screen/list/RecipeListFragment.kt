package com.medaedina.bookofrecipes.presentation.screen.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.medaedina.bookofrecipes.databinding.FragmentRecipeListBinding
import com.medaedina.bookofrecipes.presentation.screen.list.adapter.RecipeListAdapter
import com.medaedina.bookofrecipes.presentation.viewmodel.list.RecipeListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeListFragment : Fragment() {
    private var _binding: FragmentRecipeListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<RecipeListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMeals(onSuccess = {
            val adapter = RecipeListAdapter(it)
            adapter.onItemClick = { meal ->
                findNavController().navigate(
                    RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailsFragment(
                        meal
                    )
                )
            }
            binding.recyclerViewMeals.adapter = adapter
        },
            onError = {
                Toast.makeText(
                    requireContext(),
                    "Error while loading melas",
                    Toast.LENGTH_SHORT
                )
                    .show()
            })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 