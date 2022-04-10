package ivakin.first.my_first_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.widget.doOnTextChanged
import ivakin.first.my_first_app.databinding.FragmentTimeSettingsBinding
import java.io.File


class TimeSettings : Fragment(R.layout.fragment_time_settings) {
    private var fragmentTimeSettingBinding: FragmentTimeSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTimeSettingsBinding.bind(view)
        fragmentTimeSettingBinding = binding
        val file = File(context?.filesDir, "time_data.txt")
        binding.textView.text = file.readText()
        binding.button.setOnClickListener {
            val res = binding.textInput.text.toString().split(" ").map{it.toInt()}
            TimeData.setCUSTOM(res[0], res[1], res[2], res[3])
            changeSettings(binding)
        }

        binding.setFFF.setOnClickListener {
            TimeData.setFFF()
            changeSettings(binding)
        }
            binding.setFSE.setOnClickListener {
            TimeData.setFSE()
            changeSettings(binding)
        }
    }

    private fun changeSettings(binding: FragmentTimeSettingsBinding) {
        val file = File(context?.filesDir, "time_data.txt")
        file.printWriter().use { out ->
            out.println(TimeData.inhale)
            out.println(TimeData.hold)
            out.println(TimeData.exhale)
            out.println(TimeData.loops)
        }
        binding.textView.text = file.readText()
    }

    override fun onDestroyView() {
        fragmentTimeSettingBinding = null
        super.onDestroyView()
    }
}