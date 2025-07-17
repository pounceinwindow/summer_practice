package com.example.summerpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.summerpractice.R
import com.example.summerpractice.adapt.CatAdapter
import com.example.summerpractice.databinding.FragmentCatListBinding
import com.example.summerpractice.model.CatModel
import com.example.summerpractice.util.CatGenerator

class CatListFragment : Fragment() {

    private var _binding: FragmentCatListBinding? = null
    private val binding get() = _binding!!

    private lateinit var catList: MutableList<CatModel>
    private lateinit var adapter: CatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catList = CatGenerator.generateCats((3..8).random()).toMutableList()

        adapter = CatAdapter(
            catList,
            onItemClicked = { cat ->
                val bundle = Bundle().apply {
                    putParcelable("catModel", cat)
                }
                findNavController().navigate(R.id.action_to_details, bundle)
            },
            onImageClicked = { updatedCat ->
            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            catList.clear()
            catList.addAll(CatGenerator.generateCats((3..10).random()))
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}