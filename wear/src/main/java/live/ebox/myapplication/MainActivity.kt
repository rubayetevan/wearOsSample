package live.ebox.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.wear.ambient.AmbientModeSupport
import live.ebox.myapplication.databinding.ActivityMainBinding
import live.ebox.myapplication.listeners.AuthListeners
import live.ebox.myapplication.util.toast
import live.ebox.myapplication.viewmodels.AuthViewModel

class MainActivity : FragmentActivity(), AmbientModeSupport.AmbientCallbackProvider,AuthListeners{
    private val authViewModel: AuthViewModel by viewModels()
    private lateinit var ambientController: AmbientModeSupport.AmbientController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.authViewModel = authViewModel
        authViewModel.authListeners = this
        ambientController = AmbientModeSupport.attach(this)
        ambientController.setAmbientOffloadEnabled(true)
    }

    override fun onStarted() {
        toast("login started")
    }

    override fun onSuccess() {
        TODO("Not yet implemented")
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
