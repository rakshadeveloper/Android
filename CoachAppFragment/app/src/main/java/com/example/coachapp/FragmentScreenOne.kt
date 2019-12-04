package com.example.coachapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_screen_one.view.*

class FragmentScreenOne: Fragment(){

    interface OnFragmentScreenOneListener {
        fun onLoginPressed()
     }


    private var welcomListener: OnFragmentScreenOneListener? = null

    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_screen_one, container, false)


        view.btnfragmentTeo.setOnClickListener{
            if (welcomListener != null) {
                welcomListener!!.onLoginPressed()
            }


        }

        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            welcomListener = activity as OnFragmentScreenOneListener

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
        welcomListener = null

    }

    override fun onDetach() {
        super.onDetach()
    }
}