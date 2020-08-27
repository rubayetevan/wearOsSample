package live.ebox.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SecondViewModel(app: Application) : AndroidViewModel(app) {
    val cc = MutableLiveData("0")

    fun increaseCount() {
        var c = cc.value?.toInt()
        c = (c ?: 0) + 1
        cc.value = c.toString()
    }
}