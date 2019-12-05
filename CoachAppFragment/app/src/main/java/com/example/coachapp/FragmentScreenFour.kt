package com.example.coachapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_screen_four.view.*
import kotlinx.android.synthetic.main.fragment_screen_three.view.*

class FragmentScreenFour : Fragment() {

    interface onFrangmentScreenFourListner {
        fun onGotToOne()

    }
    private var welcomeListener: FragmentScreenFour.onFrangmentScreenFourListner? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_screen_four, container, false)

        view.onGoTofour.setOnClickListener {
            if (welcomeListener != null) {
                welcomeListener!!.onGotToOne()
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            welcomeListener = activity as onFrangmentScreenFourListner

        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement OnFragmentScreenFourListener")
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        welcomeListener = null

    }

    override fun onDetach() {
        super.onDetach()
    }

}