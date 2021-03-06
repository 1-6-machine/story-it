package mvvm.coding.story_it.ui.round

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import mvvm.coding.story_it.R

class RoundFragment : Fragment() {

    companion object {
        fun newInstance() = RoundFragment()
    }

    private lateinit var viewModel: RoundViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.round_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RoundViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
