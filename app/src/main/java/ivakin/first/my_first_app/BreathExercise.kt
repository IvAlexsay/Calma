package ivakin.first.my_first_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ivakin.first.my_first_app.databinding.FragmentBreatheExerciseBinding
import android.os.CountDownTimer
import android.text.format.Time
import androidx.navigation.Navigation

class BreathExercise : Fragment(R.layout.fragment_breathe_exercise) {
    private var isWork: Boolean = false
    private var fragmentBreatheExerciseBinding: FragmentBreatheExerciseBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBreatheExerciseBinding.bind(view)
        fragmentBreatheExerciseBinding = binding
        cycle(binding)
        binding.endButton.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_breathe_exercise_to_start_screen)
        }
    }

    private fun cycle(binding: FragmentBreatheExerciseBinding) {
        val totalTime = TimeData.getTotalTime()
        val totalTimeLoop = TimeData.getTotalTimeLoop()
        val texts = arrayOf("Inhale", "Hold", "Exhale")
        binding.textLoops.text = TimeData.loops.toString()
        binding.textCurrentTime.text = TimeData.inhale.toString()
        binding.declarates.text = texts[0]
        object : CountDownTimer((totalTime * 1000).toLong(), (totalTimeLoop * 1000).toLong()) {
            var loops = TimeData.loops
            override fun onTick(millisUntilFinished: Long) {
                binding.textLoops.text = loops.toString()
                object : CountDownTimer((totalTimeLoop * 1000).toLong(), 1000) {
                    var digits = arrayOf(TimeData.inhale, TimeData.hold, TimeData.exhale)
                    override fun onTick(p0: Long) {
                        when {
                            digits[0] != 0 -> {
                                binding.declarates.text = texts[0]
                                binding.textCurrentTime.text = digits[0].toString()
                                digits[0]--
                            }
                            digits[1] != 0 -> {
                                binding.declarates.text = texts[1]
                                binding.textCurrentTime.text = digits[1].toString()
                                digits[1]--
                            }
                            digits[2] != 0 -> {
                                binding.declarates.text = texts[2]
                                binding.textCurrentTime.text = digits[2].toString()
                                digits[2]--
                            }
                        }
                    }
                    override fun onFinish() {}
                }.start()
                loops--
            }

            override fun onFinish() {
                binding.declarates.text = "Finish"
                binding.textCurrentTime.text = "0"
                binding.textLoops.text = "0"
                binding.endButton.visibility = View.VISIBLE
            }
        }.start()
    }

    override fun onDestroyView() {
        fragmentBreatheExerciseBinding = null
        super.onDestroyView()
    }
}