package com.example.myapplication.ui.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentGlobalBinding

class GlobalFragment : Fragment() {
    private lateinit var globalViewModel: GlobalViewModel
    private var _binding: FragmentGlobalBinding? = null
    private val args: GlobalFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        globalViewModel = ViewModelProvider(this).get(GlobalViewModel::class.java)
        _binding = FragmentGlobalBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.goToSub.setOnClickListener {
            val action = GlobalFragmentDirections.actionGlobalFragmentToSubFragmentOne()
            root.findNavController().navigate(action)
        }
        binding.caller.text = args.caller
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}