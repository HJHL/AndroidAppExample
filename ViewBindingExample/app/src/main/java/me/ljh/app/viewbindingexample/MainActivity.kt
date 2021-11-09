package me.ljh.app.viewbindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import me.ljh.app.viewbindingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null

    // this variable can only be used between onCreate() and onDestroy()!!!
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Step 2. inflate before layout
        _binding = ActivityMainBinding.inflate(layoutInflater)
        // Step 3. replace R.layout.activity_main with mBinding.root in setContentView
        setContentView(mBinding.root)
        initView()
    }

    private fun initView() {
        initViewListener()
        mBinding.clickBtn.apply {
            text = "Clicked me!"
            isAllCaps = false
        }
        mBinding.infoTv.apply {
            text = "Hi, I'm TextView"
        }
    }

    private fun initViewListener() {
        mBinding.clickBtn.apply {
            setOnClickListener {
                Toast.makeText(context, "You clicked me!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Step 4. remember to release reference to prevent memory leak
        _binding = null
    }
}