package frag

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.summerpractice.R

class MainFragmentActivity : AppCompatActivity() {

    private val mainContainerId = R.id.main_fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment_main)

        val mainView = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val keyboardInset = insets.getInsets(WindowInsetsCompat.Type.ime())
            val paddingBottom = if (keyboardInset.bottom > 0) keyboardInset.bottom else systemBars.bottom

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, paddingBottom)
            insets
        }


        val navHostFragment = supportFragmentManager.findFragmentById(mainContainerId) as NavHostFragment
        val navController = navHostFragment.navController
    }
}
