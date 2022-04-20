package ivakin.first.my_first_app

import android.os.Bundle
import android.text.format.Time
import androidx.fragment.app.Fragment
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import ivakin.first.my_first_app.databinding.FragmentTimeSettingsBinding
import ivakin.first.my_first_app.settings.ViewPagerAdapter
import ivakin.first.my_first_app.settings.screens.FirstScreen
import ivakin.first.my_first_app.settings.screens.SecondScreen
import ivakin.first.my_first_app.settings.screens.ThirdScreen
import java.io.File

class TimeSettings : Fragment(R.layout.fragment_time_settings) {
    private var fragmentTimeSettingBinding: FragmentTimeSettingsBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTimeSettingsBinding.bind(view)
        fragmentTimeSettingBinding = binding
        setSettingsToScreen(binding)
        binding.vibrationSwitch.isChecked = TimeData.isVibration
        binding.vibrationSwitch.setOnClickListener {
            TimeData.changeVibration()
            changeSettings()
        }
        binding.soundSwitch.isChecked = TimeData.isSound
        binding.soundSwitch.setOnClickListener{
            TimeData.changeSound()
            changeSettings()
        }
        val fragmentList = arrayListOf(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter
    }


    fun changeSettings(){
        val file = File(context?.filesDir, "time_data.txt")
        file.printWriter().use { out ->
            out.println(TimeData.inhale)
            out.println(TimeData.hold)
            out.println(TimeData.exhale)
            out.println(TimeData.loops)
            out.println(if (TimeData.isVibration) 1 else 0)
            out.println(if (TimeData.isSound) 1 else 0)
        }
        fragmentTimeSettingBinding?.let { setSettingsToScreen(it) }
    }

    private fun setSettingsToScreen(binding: FragmentTimeSettingsBinding) {
        binding.textInhale.text = TimeData.inhale.toString()
        binding.textHold.text = TimeData.hold.toString()
        binding.textExhale.text = TimeData.exhale.toString()
        binding.textLoops.text = TimeData.loops.toString()
    }

    override fun onDestroyView() {
        fragmentTimeSettingBinding = null
        super.onDestroyView()
    }
}