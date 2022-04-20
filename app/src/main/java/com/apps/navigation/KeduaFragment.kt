package com.apps.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.apps.navigation.databinding.FragmentKeduaBinding

class KeduaFragment : Fragment() {

    private var _binding: FragmentKeduaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeduaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aName = arguments?.getString(PertamaFragment.EXTRA_NAME)

        binding.tvName.text = "Nama Kamu: $aName"

        binding.btnNavigateToKetiga.setOnClickListener { view ->
            if (binding.etName.text.isNullOrEmpty()) {
               Toast.makeText(requireContext(), "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val action = KeduaFragmentDirections.actionKeduaFragmentToKetigaFragment()
                action.name = binding.etName.text.toString()
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}