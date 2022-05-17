package ivakin.first.my_first_app.settings.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import ivakin.first.my_first_app.R
import ivakin.first.my_first_app.TimeData
import ivakin.first.my_first_app.TimeSettings
import ivakin.first.my_first_app.databinding.FragmentFourthScreenBinding
import ivakin.first.my_first_app.databinding.FragmentThirdScreenBinding

class FourthScreen : Fragment(R.layout.fragment_fourth_screen) {
    private var fragmentFourthScreen: FragmentFourthScreenBinding? =null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFourthScreenBinding.bind(view)
        fragmentFourthScreen = binding
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
    fun setSetiings(binding: FragmentFourthScreenBinding){
        binding.numberPickerInhale.value = TimeData.inhale
        binding.numberPickerHold.value = TimeData.hold
        binding.numberPickerExhale.value = TimeData.exhale
        binding.numberPickerLoops.value = TimeData.loops
    }

    override fun onDestroyView() {
        fragmentFourthScreen = null
        super.onDestroyView()
    }
}