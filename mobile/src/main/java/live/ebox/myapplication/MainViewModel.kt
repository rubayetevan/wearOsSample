package live.ebox.myapplication

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val cc = MutableLiveData("0")

    fun increaseCount(view: View) {
        var c = cc.value?.toInt()
        c = (c ?: 0) + 1
        cc.value = c.toString()
    }
}