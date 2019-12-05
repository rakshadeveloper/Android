package com.example.coachapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_screen_teo.view.*

class FragmentScreentwo: Fragment() {


    interface OnFragmentScreentoeListener {
        fun gotoThree()

    }


    private var welcomeListener: OnFragmentScreentoeListener? = null





    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_screen_teo, container, false)

        view.btnLogin.setOnClickListener{
            if (welcomeListener != null) {
                welcomeListener!!.gotoThree()
            }


        }

        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            welcomeListener = activity!! as OnFragmentScreentoeListener

        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement OnFragmentScreentoeListener")
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