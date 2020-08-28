package live.ebox.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_temp.*


class TempActivity : FragmentActivity() {

    private var count: Int = 0
    private val secondViewModel by viewModels<SecondViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)

        count2BTN.setOnClickListener {
            count++
            count2TV?.text = "$count"

            secondViewModel.increaseCount()
        }

        secondViewModel.cc.observe(this, Observer {
            ac2CountTV?.text = it
        })

        tBTN?.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }


    }


}