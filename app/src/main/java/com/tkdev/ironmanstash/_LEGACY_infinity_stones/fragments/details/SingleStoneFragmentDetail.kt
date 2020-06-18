import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.Snackbar
import com.tkdev.ironmanstash.R
import kotlinx.android.synthetic.main.fragment_mission_single.*

class SingleStoneFragmentDetail : Fragment() {
    private var name: String? = null
    private var color = 0

    //    private int converter = 0x00222222;
    private val converter = 0
    private var quest = 0
    private var passwordInput: String? = null
    private var passwordExpected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = ""
        color = 0
        quest =0
        passwordExpected = 0
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.fragment_mission_single, container, false)
//        view.setBackgroundColor(resources.getColor(color))
//        changeBackgrounds()
//        return view
//    }

//    private fun changeBackgrounds() {
//        TODO light up background colors
//        stoneTitleTextView.setBackgroundColor(resources.getColor(color))
//        questTextView.setBackgroundColor(resources.getColor(color))
//        titleEnterPassword.setBackgroundColor(resources.getColor(color))


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        stoneTitleTextView.text = name
//        questTextView.setText(quest)
//        confirmButton.setOnClickListener {
////            passwordInput = passwordInputEditText.text.toString()
////            if (passwordInput == resources.getString(passwordExpected)) {
//                closeKeyboard()
//                activity?.supportFragmentManager?.popBackStack(InfinityFragment.FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
//                activity?.supportFragmentManager
//                        ?.beginTransaction()
//                        ?.replace(R.id.activity_container, InfinityFragment.newInstance(name!!))
//                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//                        ?.commit()
//                confirmationSnackBar()
////            } else {
////                Toast.makeText(context, "Try once more Avenger !", Toast.LENGTH_SHORT).show()
////            }
//        }
//    }
//
//    private fun confirmationSnackBar() {
//        val snackbar = Snackbar.make(view!!, "Password correct, unlocked $name !", Snackbar.LENGTH_LONG)
//        val snackBarView = snackbar.view
//        val snackBarText = snackBarView.rootView.findViewById<TextView>(R.id.snackbar_text)
//        snackBarView.setBackgroundColor(resources.getColor(color))
//        snackBarText.setTextColor(resources.getColor(android.R.color.black))
//        snackbar.show()
//    }
//
//    private fun closeKeyboard() {
//        val inputManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputManager.hideSoftInputFromWindow(activity?.currentFocus?.windowToken,
//                InputMethodManager.HIDE_NOT_ALWAYS)
//    }
//
    companion object {
        const val NAME = "name"
        const val QUEST = "quest"
        const val COLOR = "color"
        const val PASSWORD = "password"
        fun newInstance(name: String, color: Int, quest: Int, password: Int): SingleStoneFragmentDetail {
            val bundle = Bundle()
            bundle.putSerializable(NAME, name)
            bundle.putSerializable(COLOR, color)
            bundle.putSerializable(QUEST, quest)
            bundle.putSerializable(PASSWORD, password)
            val fragment = SingleStoneFragmentDetail()
            fragment.arguments = bundle
            return fragment
        }
    }
}