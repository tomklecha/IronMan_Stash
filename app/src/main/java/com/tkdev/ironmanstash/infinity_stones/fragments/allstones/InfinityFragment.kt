import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.infinity_stones.fragments.Operations
import com.tkdev.ironmanstash.infinity_stones.fragments.allstones.InfinityAdapter
import com.tkdev.ironmanstash.infinity_stones.fragments.allstones.InfinityStone
import com.tkdev.ironmanstash.infinity_stones.fragments.details.SingleStoneViewPager
import com.tkdev.ironmanstash.infinity_stones.fragments.finish_fragment.FinishFragment
import kotlinx.android.synthetic.main.fragment_infinity.*

class InfinityFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var operations: Operations
    private lateinit var infinityAdapter: InfinityAdapter
    private lateinit var infinityStones: List<InfinityStone>



    companion object {
        const val FRAGMENT_TAG = "fragment"
        const val STONE_NAME = "stoneNameNewInstance"

        fun newInstance(name: String): InfinityFragment {
            val bundle = Bundle()
            bundle.putSerializable(STONE_NAME, name)
            val fragment = InfinityFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
//            stoneNameNewInstance = arguments?.getSerializable(STONE_NAME)
//            operations = activity?.baseContext?.let { Operations(it) }!!
//            operations.updateStones(stoneNameNewInstance)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_infinity, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createViews()
        setVisibility()
        recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        gatherButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.activity_container, SingleStoneViewPager(), FRAGMENT_TAG)
                    ?.addToBackStack(FRAGMENT_TAG)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    ?.commit()
        }
        infinityGauntlet.setOnClickListener {
//            mediaPlayer = MediaPlayer.create(context, R.raw.thanos_snap_sound_effect)
//            mediaPlayer?.seekTo(800)
//            mediaPlayer?.start()
//            disappear()
//            mediaPlayer?.setOnCompletionListener {
//                if (mediaPlayer != null) {
//                    mediaPlayer?.release()
//                }
//                mediaPlayer = null
//            }
//            infinityGauntlet.setOnClickListener(null)
        }
    }

    private fun disappear() {
        val timer: Long = 5000
        infinityStonesTitlePage.animate().alpha(0.0f).duration = timer
        recycler_view.animate().alpha(0.0f).duration = timer
        infinityGauntlet.animate().alpha(0.0f)
                .setDuration(timer)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                                fragmentManager
                                ?.beginTransaction()
                                ?.replace(R.id.infinity_fragment_container, FinishFragment())
                                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                ?.commit()
                    }
                })
    }

    private fun createViews() {
        infinityGauntlet.visibility = View.INVISIBLE
//        if (arguments == null) {
            operations = activity?.applicationContext?.let { Operations(it) }!!
            recyclerViews()
//        }
//        else {
//            recyclerViews()
//        }
    }

    private fun recyclerViews() {
        infinityStones = operations.infinityStoneList as List<InfinityStone>

        infinityAdapter = activity?.applicationContext?.let { InfinityAdapter(it, infinityStones) }!!
        recycler_view.adapter = infinityAdapter
    }

    private fun setVisibility() {
//        if (operations!!.gauntletVisibility()) {
//            gauntletImage!!.visibility = View.VISIBLE
//            gatherButton!!.visibility = View.GONE
        }
    }

