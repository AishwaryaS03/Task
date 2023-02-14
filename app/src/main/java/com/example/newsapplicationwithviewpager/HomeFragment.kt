package com.example.newsapplicationwithviewpager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() ,CallBackToFragmentListener {
    private var myAdapter: RecyclerViewAdapter ?= null
    private var linearLayoutManager: LinearLayoutManager ?= null
    private var recyclerView: RecyclerView ?= null
    private var fragmentLoginFragment: LoginFragment ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view_item)
        //itemLayout = view.findViewById(R.id.frameL)
        getMyData()
        val myProfile = view.findViewById<Button>(R.id.my_profile)
        myProfile.setOnClickListener{
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val fragpager = ViewPagerFragment()
            transaction?.replace(R.id.container, fragpager)
            fragmentLoginFragment = LoginFragment()
            val backStackName = fragmentLoginFragment!!.javaClass.name
            transaction?.addToBackStack(backStackName)
            transaction?.commit()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun callBack(image: String?, news:String?) {
        Log.d("news","$news")
        Log.d("image","$image")
        (activity as MainActivity).callBackToActivity(image,news)
    }
    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!
                linearLayoutManager = LinearLayoutManager(context)
                recyclerView?.layoutManager= linearLayoutManager
                recyclerView?.setHasFixedSize(true)
                myAdapter = RecyclerViewAdapter(responseBody)
                myAdapter?.setCallBackListener(this@HomeFragment)
                recyclerView?.adapter=myAdapter
            }
            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }



}



