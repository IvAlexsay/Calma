package ivakin.first.my_first_app.settings.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import ivakin.first.my_first_app.R
import ivakin.first.my_first_app.TimeData
import ivakin.first.my_first_app.TimeSettings
import ivakin.first.my_first_app.databinding.FragmentThirdScreenBinding

class ThirdScreen: Fragment(R.layout.fragment_third_screen){
    private var fragmentThirdScreen: FragmentThirdScreenBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentThirdScreenBinding.bind(view)
        fragmentThirdScreen = binding
        binding.set.setOnClickListener {
            TimeData.setFOF()
            val navHostFragment: NavHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
            val timeSettings: TimeSettings = navHostFragment.childFragmentManager.fragments[0] as TimeSettings
            timeSettings.changeSettings()
        }
    }
    override fun onDestroyView() {
        fragmentThirdScreen = null
        super.onDestroyView()
    }
}