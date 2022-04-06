package ivakin.first.my_first_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ivakin.first.my_first_app.databinding.FragmentTimeSettingsBinding
import ivakin.first.my_first_app.viewmodels.TimeSettingsViewModel

class TimeSettings : Fragment() {
    //private lateinit var viewModel: TimeSettingsViewModel
    private lateinit var binding: FragmentTimeSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTimeSettingsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = TimeSettingsViewModel()
        return binding.root
    }

}