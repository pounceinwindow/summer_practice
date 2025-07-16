package frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.summerpractice.databinding.FragmentAvgBinding
import com.example.summerpractice.databinding.FragmentMainBinding

class AvgFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initViews()
        val email = arguments?.getString("SampleKey")
        val password = arguments?.getString("Sample1Key")
        viewBinding?.email?.text = "ваш email : $email"
        viewBinding?.pass?.text = "ваш пароль : $password"
    }
    private var viewBinding: FragmentAvgBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):

            View? {
//        val fragmentView = inflater.inflate(R.layout.fragment_main, container, false)

        viewBinding = FragmentAvgBinding.inflate(inflater, container, false)
        return viewBinding?.root


    }

}