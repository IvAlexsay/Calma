package ivakin.first.my_first_app.settings.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.NumberPicker
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import ivakin.first.my_first_app.R
import ivakin.first.my_first_app.TimeData
import ivakin.first.my_first_app.TimeSettings
import ivakin.first.my_first_app.databinding.FragmentThirdScreenBinding
import java.io.File

class ThirdScreen : Fragment(R.layout.fragment_third_screen) {
    private var fragmentThirdScreenBinding: FragmentThirdScreenBinding?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentThirdScreenBinding.bind(view)
        fragmentThirdScreenBinding = binding
        setSetiings(binding)
        binding.set.setOnClickListener {
            TimeData.setCUSTOM(
                binding.numberPickerInhale.value,
                binding.numberPickerHold.value,
                binding.numberPickerExhale.value,
                binding.numberPickerLoops.value
            )
            val navHostFragment: NavHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
            val timeSettings: TimeSettings = navHostFragment.childFragmentManager.fragments[0] as TimeSettings
            timeSettings.changeSettings()
        }
    }

    fun setSetiings(binding: FragmentThirdScreenBinding){
        binding.numberPickerInhale.value = TimeData.inhale
        binding.numberPickerHold.value = TimeData.hold
        binding.numberPickerExhale.value = TimeData.exhale
        binding.numberPickerLoops.value = TimeData.loops
    }

    override fun onDestroyView() {
        fragmentThirdScreenBinding = null
        super.onDestroyView()
    }
}