package com.example.coachapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_screen_three.view.*

class FragmentScreenThree : Fragment() {

    interface OnFragmentScreenThreeListener{
        fun gotoFour()
    }
    private var welcomeListener: OnFragmentScreenThreeListener? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_screen_three, container, false)

        view.goTo4.setOnClickListener {
            if (welcomeListener != null) {
                welcomeListener!!.gotoFour()
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            welcomeListener = activity as OnFragmentScreenThreeListener

        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement OnFragmentScreenThreeListener")
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