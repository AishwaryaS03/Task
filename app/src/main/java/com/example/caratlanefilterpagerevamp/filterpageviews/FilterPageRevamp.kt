package com.example.caratlanefilterpagerevamp.filterpageviews
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caratlanefilterpagerevamp.*
import com.example.caratlanefilterpagerevamp.filterpagedataclass.ItemsViewModelSubList
import com.example.caratlanefilterpagerevamp.filterpageviewmodel.SubListViewModel
import kotlinx.coroutines.launch
import java.sql.RowId
class FilterPageRevamp : Fragment() {
    private lateinit var recyclerViewMainList: RecyclerView
    private lateinit var recyclerViewSubList: RecyclerView
    private lateinit var mainListAdapter: MainListAdapter
    private lateinit var circleTextView: TextView
    private lateinit var subListAdapter: SubListAdapter
    private lateinit var subListViewModel: SubListViewModel
    private lateinit var resetButton: AppCompatButton
    private lateinit var progressBar: ProgressBar
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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.filter_page_revamp, container, false)
        val secondLayout = inflater.inflate(R.layout.main_list_view_design, container, false)
        recyclerViewMainList = view.findViewById(R.id.recycler_view_main_list)
        recyclerViewSubList = view.findViewById(R.id.recycler_view_sub_list)
        progressBar = view.findViewById(R.id.pBar)
        recyclerViewMainList.layoutManager = LinearLayoutManager(activity)
        recyclerViewSubList.layoutManager = LinearLayoutManager(activity)
        circleTextView = secondLayout.findViewById(R.id.circle_main_list)
        resetButton = view.findViewById(R.id.button_reset)
        val mainListData = ArrayList<MainItemsViewModel>()
        for (element in mainList) {
            mainListData.add(MainItemsViewModel(element))
        }
        subListViewModel = ViewModelProvider(this).get(SubListViewModel::class.java)
        mainListAdapter = MainListAdapter(mainListData, subListViewModel)
        recyclerViewMainList.adapter = mainListAdapter
        mainListAdapter.setItemClickListener { position ->
            val subListData = ArrayList<ItemsViewModelSubList>()
            if (position >= 0 && position < subList.size) {
                for (i in 0 until subList[position].size) {
                    subListData.add(ItemsViewModelSubList(subList[position][i]))
                }
            }
            subListAdapter = SubListAdapter(subListData,subListViewModel)
            recyclerViewSubList.adapter = subListAdapter
        }
        val subListData = ArrayList<ItemsViewModelSubList>()
        for (i in 0 until subList[0].size) {
            subListData.add(ItemsViewModelSubList(subList[0][i]))
        }
        subListAdapter = SubListAdapter(subListData,subListViewModel)
        recyclerViewSubList.adapter = subListAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetButton.setOnClickListener {
            subListViewModel.refreshCheckedCount()
            subListViewModel.unChecked(isChecked = false)
            progressBar.visibility = View.VISIBLE
            Handler().postDelayed({
                progressBar.setVisibility(View.INVISIBLE)
            },1000)
            Toast.makeText(context,"RESET SUCCESSFUL",Toast.LENGTH_LONG).show()
        }
        }
    }



