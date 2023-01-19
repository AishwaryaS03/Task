package com.example.recyclerviewdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private  lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j
        )

        heading = arrayOf(

            "The cryptoverse witnessed a major boom in terms of the numbers.",
            "On Tuesday, CEO of FTX, John Ray, said to have lost 415 million since it filed for bankruptcy in the US court.",
            "World Economic Forum kickstarts a metaverse platform to combat global challenges & crisis",
            "Crypto prices today: Bitcoin & Ethereum continue to grow, Solana & metaverse tokens dip",
            "Why the crypto market is in the green these days? Here are the top reasons",
            "Microsoft announces to add ChatGPT to Azure, why is it important for users?",
            "A Web3 firm launches a decentralised super app offering a one-stop solution for users",
            "Crypto prices today: Bitcoin increases, Ether, Solana & digital currencies fall",
            "India’s first AI-based music tech startup, Beatoven.ai plans to expand in 2023",
            "The US has started teaching students about Bitcoin & blockchain in colleges"


        )

        news = arrayOf(

            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
            getString(R.string.news_j)
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<News>()
        getUserdata()

    }


    private fun getUserdata() {

        for (i in imageId.indices){
            val news = News(imageId[i],heading[i])
            newArrayList.add(news)
        }
        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity,"You Clicked on item no. $position",Toast.LENGTH_SHORT).show()



            }


        })
    }
}