package me.ycdev.android.demo.customviews.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.ycdev.android.demo.customviews.R

class EventsFragment : Fragment() {

    private lateinit var eventsViewModel: EventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        eventsViewModel = ViewModelProvider(this).get(EventsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_events, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        eventsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}