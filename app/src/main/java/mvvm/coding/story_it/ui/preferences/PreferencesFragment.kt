package mvvm.coding.story_it.ui.preferences

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.start_fragment.*

import mvvm.coding.story_it.R
import mvvm.coding.story_it.databinding.StartFragmentBinding
import mvvm.coding.story_it.ui.start.StartViewModel
import mvvm.coding.story_it.ui.start.startFragment
import mvvm.coding.story_it.ui.start.startFragmentDirections
import org.koin.android.viewmodel.ext.android.viewModel




//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding : StartFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.start_fragment, container, false)
//        binding.viewModel = viewModel
//
//        binding.setLifecycleOwner(this)
//        return binding.root
//    }
class PreferencesFragment : Fragment() {

    companion object {
        fun newInstance() = PreferencesFragment()
    }

    private lateinit var viewModel: PreferencesViewModel
    lateinit var action : PreferencesFragmentDirections

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.preferences_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PreferencesViewModel::class.java)
        // TODO: Use the ViewModel
    }
    private fun setupListeners(){
        new_game_btn.setOnClickListener { findNavController().navigate(PreferencesFragmentDirections.actionPreferencesFragmentToRoundFragment()) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupListeners()
        super.onViewCreated(view, savedInstanceState)

    }
}

