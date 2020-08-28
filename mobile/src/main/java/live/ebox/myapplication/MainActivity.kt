package live.ebox.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_example.*
import live.ebox.myapplication.databinding.ActivityExampleBinding


class MainActivity : FragmentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityExampleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_example)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        tBTN?.setOnClickListener {
            //startActivity(Intent(this, SecondActivity::class.java))
            startActivity(Intent(this, TempActivity::class.java))
        }
    }



}
