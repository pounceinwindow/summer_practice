package com.example.summerpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.summerpractice.databinding.FragmentCatDetailBinding

class CatDetailFragment : Fragment() {

    private var _binding: FragmentCatDetailBinding? = null
    private val binding get() = _binding!!

    private val args: CatDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cat = args.catModel
        binding.imageView.setImageResource(cat.imageResId)
        binding.titleText.text = cat.title
        binding.descriptionText.text = cat.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
