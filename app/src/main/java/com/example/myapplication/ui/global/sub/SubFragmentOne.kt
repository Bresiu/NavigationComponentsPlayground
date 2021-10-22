package com.example.myapplication.ui.global.sub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSubOneBinding

class SubFragmentOne : Fragment() {
    private val viewModel: SubViewModel by navGraphViewModels(R.id.main_graph)
    private var _binding: FragmentSubOneBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubOneBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.goToNext.setOnClickListener {
            val action = SubFragmentOneDirections.actionSubFragmentOneToSubFragmentTwo()
            root.findNavController().navigate(action)
        }
        viewModel.text.observe(viewLifecycleOwner) {
            binding.subCounter.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}