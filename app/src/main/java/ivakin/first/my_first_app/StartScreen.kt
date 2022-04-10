package ivakin.first.my_first_app

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ivakin.first.my_first_app.databinding.FragmentStartScreenBinding
import java.io.File



class StartScreen : Fragment(R.layout.fragment_start_screen) {
    private var fragmentStartScreenBinding: FragmentStartScreenBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentStartScreenBinding.bind(view)
        fragmentStartScreenBinding = binding
        context?.let { setDefaultSettingsFile(it) }
        setSettingsToScreen(binding)
        binding.startButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_start_screen_to_breathe_exercise)
        }
        binding.timeSettingsBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_start_screen_to_time_settings)
        }
    }

    private fun setSettingsToScreen(binding: FragmentStartScreenBinding) {
        binding.textInhale.text = TimeData.inhale.toString()
        binding.textHold.text = TimeData.hold.toString()
        binding.textExhale.text = TimeData.exhale.toString()
        binding.textLoops.text = TimeData.loops.toString()
    }

    private fun setDefaultSettingsFile(context: Context) {
        val file = File(context.filesDir, "time_data.txt")
        if (file.exists()) {
            var data = file.readText()
            data = data.substring(0, data.length-1)
            val set = data.split('\n').map{it.toInt()}
            TimeData.setCUSTOM(set[0], set[1], set[2], set[3])
        }
        else{
            file.printWriter().use { out ->
                out.println(TimeData.inhale)
                out.println(TimeData.hold)
                out.println(TimeData.exhale)
                out.println(TimeData.loops)
            }
        }
    }

    override fun onDestroyView() {
        fragmentStartScreenBinding = null
        super.onDestroyView()
    }
}