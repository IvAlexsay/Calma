package ivakin.first.my_first_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ivakin.first.my_first_app.databinding.FragmentTimeSettingsBinding

import ivakin.first.my_first_app.viewmodels.TimeSettingsViewModel

class TimeSettings : Fragment(R.layout.fragment_time_settings) {
    private var fragmentTimeSettingBinding: FragmentTimeSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTimeSettingsBinding.bind(view)
        fragmentTimeSettingBinding = binding
        binding.textView.text = "fuck"
    }

    override fun onDestroyView() {
        fragmentTimeSettingBinding = null
        super.onDestroyView()
    }
}