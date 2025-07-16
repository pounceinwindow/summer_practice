package frag

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.R
import com.example.summerpractice.databinding.FragmentMain2Binding
import com.example.summerpractice.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMain2Binding? = null
    private val binding get() = _binding!!

    private var isEmailValid = false
    private var isPasswordValid = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMain2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val keyboardInset = insets.getInsets(WindowInsetsCompat.Type.ime())
            val paddingBottom =
                if (keyboardInset.bottom > 0) keyboardInset.bottom else systemBars.bottom

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, paddingBottom)
            insets
        }

        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initView() {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$".toRegex()

        fun updateButtonState() {
            binding.button.isEnabled = isEmailValid && isPasswordValid
        }

        binding.emailet.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = s?.toString() ?: ""
                isEmailValid = Patterns.EMAIL_ADDRESS.matcher(text).matches()
                updateButtonState()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.passBox.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = s?.toString() ?: ""
                isPasswordValid = passwordPattern.matches(text)
                updateButtonState()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })
        binding.button.setOnClickListener { findNavController().navigate(R.id.action_mainFragment_to_avgFragment) }
    }


}
