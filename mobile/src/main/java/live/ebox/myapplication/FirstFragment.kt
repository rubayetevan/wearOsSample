package live.ebox.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {
    private lateinit var firstFragmentView: View
    private val secondViewModel by activityViewModels<SecondViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        firstFragmentView = inflater.inflate(R.layout.fragment_first, container, false)
        return firstFragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        f1TrnsBtn?.setOnClickListener {
            Navigation.findNavController(firstFragmentView).navigate(R.id.secondFragment)
        }

        secondViewModel.cc.observe(viewLifecycleOwner, {
            fCount2TV?.text = (it ?: "0")
        })

        f1IncBtn?.setOnClickListener {
            secondViewModel.increaseCount()
        }

    }
}