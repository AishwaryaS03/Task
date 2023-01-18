package com.example.modiefiedtask2
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Fragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = layoutInflater.inflate(R.layout.fragment_2, container, false)
        val inputText = arguments?.getString("input_txt")
        val outputTextView = rootView.findViewById<TextView>(R.id.output_textview)
        outputTextView.text = inputText
        return rootView
    }

}