package live.ebox.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {
    private lateinit var secondFragmentView: View
    private val secondViewModel by activityViewModels<SecondViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        secondFragmentView = inflater.inflate(R.layout.fragment_second, container, false)
        return secondFragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fCount2TV?.setOnClickListener {
            // Navigation.findNavController(secondFragmentView).navigateUp()
            secondViewModel.increaseCount()
        }
        secondViewModel.cc.observe(viewLifecycleOwner, {
            fCount2TV?.text = (it ?: "0") + "\nSecond fragment"
        })

    }


}