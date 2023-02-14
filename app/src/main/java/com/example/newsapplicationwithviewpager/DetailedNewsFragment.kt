package com.example.newsapplicationwithviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailedNewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val news: TextView
        val image: ImageView

        val view = inflater.inflate(R.layout.fragment_detailed_news, container, false)
        news = view.findViewById(R.id.detailed_news)
        image = view.findViewById(R.id.large_image)
        val data = arguments
        val detailNews = data?.getString("news")
        news.text = detailNews
        val imageV = data?.getString("image")
        context?.let {
            Glide.with(it)
                .load(imageV)
                .into(image)
        }
        return view
    }

}