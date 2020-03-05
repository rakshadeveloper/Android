package com.example.youtubersapp.tabfragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubersapp.R
import com.example.youtubersapp.adapter.VideoRecyclerAdapter
import com.example.youtubersapp.model.AllVideos
import kotlinx.android.synthetic.main.fragment_video.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MovieFragment : Fragment() {


    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var adapter: VideoRecyclerAdapter
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val items = listOf(
            AllVideos("Premature optimization is the root of all evil", null),
            AllVideos("Any sufficiently advanced technology is indistinguishable from magic.", "Arthur C. Clarke"),
            AllVideos("Content 01", "Source"),
            AllVideos("Content 02", "Source"),
            AllVideos("Content 03", "Source"),
            AllVideos("Content 04", "Source"),
            AllVideos("Content 05", "Source")
        )

        adapter = VideoRecyclerAdapter()
        adapter.replaceItems(items)
        
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_video, container, false)
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
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
