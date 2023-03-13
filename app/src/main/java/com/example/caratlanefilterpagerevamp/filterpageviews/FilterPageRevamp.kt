package com.example.caratlanefilterpagerevamp.filterpageviews

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caratlanefilterpagerevamp.*
import com.example.caratlanefilterpagerevamp.filterpagedataclass.ItemsViewModelSubList
import com.example.caratlanefilterpagerevamp.filterpageviewmodel.FilterPageRevampViewModel
import kotlinx.coroutines.launch
import java.sql.RowId

class FilterPageRevamp : Fragment() {

    private lateinit var recyclerViewMainList: RecyclerView
    private lateinit var recyclerViewSubList: RecyclerView
    private lateinit var mainListAdapter: MainListAdapter
    private lateinit var circleTextView: TextView
    private lateinit var subListAdapter: SubListAdapter
    private lateinit var filterPageRevampViewModel: FilterPageRevampViewModel
    override fun onAttach(context: Context) {
        super.onAttach(context)
        filterPageRevampViewModel = ViewModelProvider(this).get(FilterPageRevampViewModel::class.java)
    }

    private val mainList = arrayOf(
        "Material",
        "Occasions",
        "Stones",
        "Events",
        "Style",
        "New Launches",
        "Gift",
        "Ferrero",
        "Elixir",
        "Ninjas"
    )
    private val subList = arrayOf(
        arrayOf("Platinum", "Diamond", "Gem Stone", "Solitaire"),
        arrayOf("Anniversary", "Party Wear", "Everyday"),
        arrayOf("Ruby", "Moon Stone", "Emerald"),
        arrayOf("Halo", "Ring", "Bridal"),
        arrayOf("Midi", "Top Picks", "Fashion", "Traditional", "Floral"),
        arrayOf("Infinity", "Harry Potter", "Social Celeb"),
        arrayOf("The Colleagues", "Main Women"),
        arrayOf("Platinum", "Diamond", "Gem Stone", "Solitaire"),
        arrayOf("Anniversary", "Party Wear", "Everyday"),
        arrayOf("Ruby", "Moon Stone", "Emerald")
    )

    private var count = MutableLiveData<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.filter_page_revamp, container, false)
        val secondLayout = inflater.inflate(R.layout.main_list_view_design, container, false)
        val checkedCount = 0
        recyclerViewMainList = view.findViewById(R.id.recycler_view_main_list)
        recyclerViewSubList = view.findViewById(R.id.recycler_view_sub_list)
        recyclerViewMainList.layoutManager = LinearLayoutManager(activity)
        recyclerViewSubList.layoutManager = LinearLayoutManager(activity)
        circleTextView = secondLayout.findViewById(R.id.circle_main_list)

        val mainListData = ArrayList<MainItemsViewModel>()
        for (element in mainList) {
            mainListData.add(MainItemsViewModel(element))
        }
        mainListAdapter = MainListAdapter(mainListData)
        recyclerViewMainList.adapter = mainListAdapter
        mainListAdapter.setItemClickListener { position ->
            val subListData = ArrayList<ItemsViewModelSubList>()
            if (position >= 0 && position < subList.size) {
                for (i in 0 until subList[position].size) {
                    subListData.add(ItemsViewModelSubList(subList[position][i]))
                }
            }
            subListAdapter = SubListAdapter(subListData)
            recyclerViewSubList.adapter = subListAdapter

        }

        val subListData = ArrayList<ItemsViewModelSubList>()
        for (i in 0 until subList[0].size) {
            subListData.add(ItemsViewModelSubList(subList[0][i]))
        }
        subListAdapter = SubListAdapter(subListData)
        recyclerViewSubList.adapter = subListAdapter
        filterPageRevampViewModel.updateCheckedCount(checkedCount)
        return view

    }

}


