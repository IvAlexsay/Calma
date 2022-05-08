package ivakin.first.my_first_app.settings.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.navigation.fragment.NavHostFragment
import ivakin.first.my_first_app.R
import ivakin.first.my_first_app.TimeData
import ivakin.first.my_first_app.TimeSettings
import ivakin.first.my_first_app.databinding.FragmentFirstScreenBinding
import ivakin.first.my_first_app.databinding.FragmentSecondScreenBinding
import java.io.File

class SecondScreen : Fragment(R.layout.fragment_second_screen) {
    private var fragmentSecondScreen: FragmentSecondScreenBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSecondScreenBinding.bind(view)
        fragmentSecondScreen = binding
        TimeData.setFFF()
        binding.set.setOnClickListener {
            val navHostFragment: NavHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
            val timeSettings: TimeSettings = navHostFragment.childFragmentManager.fragments[0] as TimeSettings
            timeSettings.changeSettings()
        }
    }

}