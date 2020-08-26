package live.ebox.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import live.ebox.myapplication.databinding.ActivityExampleBinding


class MainActivity : FragmentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityExampleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_example)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
    }



}
