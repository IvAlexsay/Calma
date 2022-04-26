package ivakin.first.my_first_app


import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Vibrator
import android.view.View
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ivakin.first.my_first_app.databinding.FragmentBreatheExerciseBinding


class BreathExercise : Fragment(R.layout.fragment_breathe_exercise) {
    private var fragmentBreatheExerciseBinding: FragmentBreatheExerciseBinding? = null
    private lateinit var timerLoops: CountDownTimer
    private lateinit var timerLoop: CountDownTimer
    private lateinit var mSoundPool: SoundPool
    private lateinit var animationEnlarge: Animation
    private lateinit var animationCompression: Animation
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBreatheExerciseBinding.bind(view)
        fragmentBreatheExerciseBinding = binding
        val attributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(attributes)
            .setMaxStreams(1)
            .build()
        mSoundPool.load(activity, R.raw.wow, 1)
        mSoundPool.load(activity, R.raw.shelck, 1)

        setAnimations()

        cycle(binding)
        binding.endButton.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_breathe_exercise_to_start_screen)
        }
    }

    private fun setAnimations() {
        animationEnlarge = AnimationUtils.loadAnimation(activity, R.anim.enlarge)
        animationCompression = AnimationUtils.loadAnimation(activity, R.anim.compression)
        animationEnlarge.duration = (TimeData.inhale * 1000).toLong()
        animationCompression.startOffset = (TimeData.hold * 1000).toLong()
        animationCompression.duration = (TimeData.exhale * 1000).toLong()
    }

    private fun cycle(binding: FragmentBreatheExerciseBinding) {
        val totalTime = TimeData.getTotalTime()
        val totalTimeLoop = TimeData.getTotalTimeLoop()
        val texts = arrayOf("Inhale", "Hold", "Exhale")
        val vibrator = activity?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val flower = binding.flower
        binding.textLoops.text = TimeData.loops.toString()
        binding.textCurrentTime.text = TimeData.inhale.toString()
        binding.declarates.text = texts[0]
        animationEnlarge.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                flower.startAnimation(animationCompression)
            }

            override fun onAnimationRepeat(p0: Animation?) {}

        })
        timerLoops =
            object : CountDownTimer((totalTime * 1000).toLong(), (totalTimeLoop * 1000).toLong()) {
                var loops = TimeData.loops
                override fun onTick(millisUntilFinished: Long) {
                    loops--
                    binding.textLoops.text = loops.toString()
                    flower.startAnimation(animationEnlarge)
                    timerLoop = object : CountDownTimer((totalTimeLoop * 1000).toLong(), 1000) {
                        var digits = arrayOf(TimeData.inhale, TimeData.hold, TimeData.exhale)
                        override fun onTick(p0: Long) {
                            when {
                                digits[0] == 0 -> {
                                    vibratePhone(vibrator)
                                    playSound(2)
                                    digits[0]--
                                }
                                digits[1] == 0 -> {
                                    vibratePhone(vibrator)
                                    playSound(2)
                                    digits[1]--

                                }
                                digits[2] == 0 -> {
                                    vibratePhone(vibrator)
                                    playSound(2)
                                    digits[2]--
                                }
                            }
                            when {
                                digits[0] > 0 -> {
                                    binding.declarates.text = texts[0]
                                    binding.textCurrentTime.text = digits[0].toString()
                                    digits[0]--
                                }
                                digits[1] > 0 -> {
                                    binding.declarates.text = texts[1]
                                    binding.textCurrentTime.text = digits[1].toString()
                                    digits[1]--
                                }
                                digits[2] > 0 -> {
                                    binding.declarates.text = texts[2]
                                    binding.textCurrentTime.text = digits[2].toString()
                                    digits[2]--
                                }
                            }
                        }

                        override fun onFinish() {}
                    }.start()
                    playSound(2)
                }

                override fun onFinish() {
                    playSound(1)
                    binding.declarates.text = "Finish"
                    binding.textCurrentTime.text = "0"
                    binding.textLoops.text = "0"
                    binding.endButton.visibility = View.VISIBLE
                    flower.animation = null
                }
            }.start()
    }

    fun playSound(id: Int) {
        if (!TimeData.isSound) {
            return
        }
        val audioManager =
            activity?.getSystemService(AppCompatActivity.AUDIO_SERVICE) as AudioManager
        val curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC).toFloat()
        val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC).toFloat()
        val leftVolume = curVolume / maxVolume
        val rightVolume = curVolume / maxVolume
        val priority = 1
        val noLoop = 0
        val normalPlaybackRate = 1f
        mSoundPool.play(id, leftVolume, rightVolume, priority, noLoop, normalPlaybackRate)
    }

    fun vibratePhone(vibrator: Vibrator) {
        if (!TimeData.isVibration) {
            return;
        }
        vibrator.vibrate(200)
    }

    override fun onDestroyView() {
        timerLoops.cancel()
        timerLoop.cancel()
        fragmentBreatheExerciseBinding = null
        super.onDestroyView()
    }
}