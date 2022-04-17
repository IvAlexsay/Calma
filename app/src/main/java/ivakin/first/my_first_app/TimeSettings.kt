package ivakin.first.my_first_app

import android.os.Bundle
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

        val fragmentList = arrayListOf<Fragment>(
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
        }
        fragmentTimeSettingBinding?.textView?.text = file.readText()
    }

    override fun onDestroyView() {
        fragmentTimeSettingBinding = null
        super.onDestroyView()
    }
}