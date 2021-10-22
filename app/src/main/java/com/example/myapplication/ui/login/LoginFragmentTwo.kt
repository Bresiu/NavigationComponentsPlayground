package com.example.myapplication.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.ActivityViewModel
import com.example.myapplication.databinding.FragmentLoginTwoBinding

class LoginFragmentTwo : Fragment() {
    private val activityViewModel: ActivityViewModel by activityViewModels()
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
        val root: View = binding.root
        binding.goToMainScreen.setOnClickListener {
            // TODO
//            val  navController = findNavController()
//            val startDestination = navController.graph.
//            val navOptions = NavOptions.Builder()
//                .setPopUpTo(startDestination, true)
//                .build()
//            navController.navigate(startDestination, null, navOptions)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}