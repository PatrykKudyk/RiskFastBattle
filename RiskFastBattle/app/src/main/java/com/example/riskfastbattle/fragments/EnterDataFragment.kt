package com.example.riskfastbattle.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.riskfastbattle.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AccountFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EnterDataFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var rootView: View
    private lateinit var attackersEditText: EditText
    private lateinit var defendersEditText: EditText
    private lateinit var fightButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_enter_data, container, false);
        initFragment()
        return rootView
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            EnterDataFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun initFragment() {
        attackersEditText = rootView.findViewById(R.id.enter_data_edit_text_attacker)
        defendersEditText = rootView.findViewById(R.id.enter_data_edit_text_defender)
        fightButton = rootView.findViewById(R.id.enter_data_button_begin_fight)

        fightButton.setOnClickListener {
            if (attackersEditText.text.toString() != "" && defendersEditText.text.toString() != "") {
                if (attackersEditText.text.toString().toInt() != 0 && defendersEditText.text.toString().toInt() != 0
                ) {
                    val fightFragment = FightFragment.newInstance(
                        attackersEditText.text.toString().toInt(),
                        defendersEditText.text.toString().toInt()
                    )
                    attackersEditText.setText("")
                    defendersEditText.setText("")
                    fragmentManager
                        ?.beginTransaction()
                        ?.setCustomAnimations(
                            R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                            R.anim.enter_right_to_left, R.anim.exit_left_to_right
                        )
                        ?.replace(R.id.frame_layout, fightFragment)
                        ?.addToBackStack(FightFragment.toString())
                        ?.commit()
                } else {
                    Toast.makeText(rootView.context, R.string.toast_cant_be_0, Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(rootView.context, R.string.toast_fill_fields, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}