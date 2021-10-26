package com.example.myapplication.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import com.example.myapplication.ActivityViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginTwoBinding

class LoginFragmentTwo : Fragment() {
    private val activityViewModel: ActivityViewModel by activityViewModels()
    private lateinit var savedStateHandle: SavedStateHandle
    private var _binding: FragmentLoginTwoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
        binding.login.setOnClickListener { login() }
    }

    private fun login() {
        activityViewModel.login().observe(viewLifecycleOwner) { state ->
            when (state) {
                ActivityViewModel.LoginState.Progress -> {
                    binding.login.visibility = View.GONE
                    binding.progress.visibility = View.VISIBLE
                }
                ActivityViewModel.LoginState.Success -> {
                    findNavController().popBackStack(R.id.globalFragment, inclusive = false)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}