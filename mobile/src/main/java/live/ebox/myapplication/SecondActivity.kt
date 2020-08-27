package live.ebox.myapplication

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class SecondActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}