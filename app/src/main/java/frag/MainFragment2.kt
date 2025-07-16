package frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.R
import com.example.summerpractice.databinding.FragmentMainBinding
import java.util.Random

class MainFragment2 : Fragment() {
    private val random = Random()
    val picturesList = listOf(
        R.drawable.image2, R.drawable.image3,
        R.drawable.image4, R.drawable.image5,
        R.drawable.image6, R.drawable.image7,
        R.drawable.image8, R.drawable.image9
    )
    private var viewBinding: FragmentMainBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
//        val fragmentView = inflater.inflate(R.layout.fragment_main, container, false)
        viewBinding = FragmentMainBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

    }

    fun initViews() {
        viewBinding?.apply {
            gambling.setOnClickListener {
                val number = random.nextInt(picturesList.size)
                textView3.text = "Ваше число : $number"
                drawa.setImageResource(picturesList[number])
            }

            button2.setOnClickListener { findNavController().navigate(R.id.action_main_fragment2_to_mainFragment) }
        }


    }

}

