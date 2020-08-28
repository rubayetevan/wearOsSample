package live.ebox.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {
    val cc = MutableLiveData("0")

    fun increaseCount() {
        var c = cc.value?.toInt()
        c = (c ?: 0) + 1
        cc.value = c.toString()
    }
}