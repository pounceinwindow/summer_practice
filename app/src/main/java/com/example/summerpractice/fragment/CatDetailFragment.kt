package com.example.summerpractice.fragment



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.summerpractice.databinding.FragmentCatDetailBinding
import com.example.summerpractice.model.CatModel

class CatDetailFragment : Fragment() {

    private var _binding: FragmentCatDetailBinding? = null
    private val binding get() = _binding!!

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
        val cat = arguments?.getParcelable<CatModel>("catModel")
        cat?.let {
            binding.imageView.setImageResource(it.imageResId)
            binding.titleText.text = it.title
            binding.descriptionText.text = it.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}