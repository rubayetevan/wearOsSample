package live.ebox.myapplication.viewmodels
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import live.ebox.myapplication.listeners.AuthListeners

class AuthViewModel : ViewModel() {
    val TAG:String ="AuthViewModel"
    var username:String?=null
    var password:String?=null
    var authListeners:AuthListeners?=null

    fun submitButtonOnclick(view:View){

        authListeners?.onStarted()
        Log.d(TAG,"onClick pressed : $username")

    }





}