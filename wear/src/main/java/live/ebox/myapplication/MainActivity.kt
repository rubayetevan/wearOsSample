package live.ebox.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.wear.ambient.AmbientModeSupport
import live.ebox.myapplication.database.TestTable
import live.ebox.myapplication.databinding.ActivityMainBinding
import live.ebox.myapplication.listeners.AuthListeners
import live.ebox.myapplication.util.toast
import live.ebox.myapplication.viewmodels.AuthViewModel

class MainActivity : FragmentActivity(), AmbientModeSupport.AmbientCallbackProvider,AuthListeners{
    private val authViewModel: AuthViewModel by viewModels()
    private lateinit var ambientController: AmbientModeSupport.AmbientController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = authViewModel
        authViewModel.authListeners = this
        ambientController = AmbientModeSupport.attach(this)
        ambientController.setAmbientOffloadEnabled(true)
    }

    val employeeTablCchangeObserver = Observer<List<TestTable>> {

        Log.d("HomeActivity", "data size = ${it.size}")

        toast("data size = ${it.size}")
    }

    override fun onStarted() {
        toast("login started")
    }

    override fun onSuccess() {
        authViewModel.getData().observe(this, employeeTablCchangeObserver)
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }

    override fun getAmbientCallback(): AmbientModeSupport.AmbientCallback {
        return  MyAmbientCallback()
    }

    private class MyAmbientCallback : AmbientModeSupport.AmbientCallback() {

        override fun onEnterAmbient(ambientDetails: Bundle?) {
            // Handle entering ambient mode
        }

        override fun onExitAmbient() {
            // Handle exiting ambient mode
        }

        override fun onUpdateAmbient() {
            // Update the content
        }
    }
}
