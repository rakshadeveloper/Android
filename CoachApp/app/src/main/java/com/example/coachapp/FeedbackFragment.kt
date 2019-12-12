package com.example.coachapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FeedbackFragment : Fragment() {

    interface OnFeedbackFragmentListner {

    }
    private var welcomeListener: OnFeedbackFragmentListner? = null

    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_feedback, container, false)

        return view
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            welcomeListener = activity as OnFeedbackFragmentListner

        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement OnFeedbackFragmentListner")
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