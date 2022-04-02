package ivakin.first.my_first_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation

class StartScreen : Fragment() {
    //val timeDataViewModel = TimeDataViewModel()
    //val binding: FragmentStartScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val timeData = TimeData(4, 7, 8, 4)
        val view = inflater.inflate(R.layout.fragment_start_screen, container, false)

        view.findViewById<Button>(R.id.play_btn).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_start_screen_to_breathe_exercise)
        }
        view.findViewById<Button>(R.id.leaderboard_btn).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_start_screen_to_time_settings)
        }
        return view
    }
}