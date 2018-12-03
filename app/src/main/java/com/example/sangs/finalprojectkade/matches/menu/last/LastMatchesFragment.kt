package com.example.sangs.finalprojectkade.matches.menu.last


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
import com.example.sangs.finalprojectkade.Model.model.ResponseModel

import com.example.sangs.finalprojectkade.R
import com.example.sangs.finalprojectkade.matches.menu.MatchAdapters
import com.example.sangs.finalprojectkade.matches.menu.MatchSpinners
import com.example.sangs.finalprojectkade.matches.menu.menudetail.DetailActivityMatches
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity

class LastMatchesFragment : Fragment(),LastMatchesView{

    override fun showLeagues(dataItems: List<ResponseModel?>?) {
        if (dataItems != null) {
            this.dataItemsLeague?.addAll(dataItems)
        }
        adapter.notifyDataSetChanged()
    }

    override fun showEvents(dataItems: List<ResponseModel?>?) {
        this.dataItemsEvents?.clear()
        if (dataItems != null) {
            this.dataItemsEvents?.addAll(dataItems)
        }
        adapterRecycler.notifyDataSetChanged()
    }

    private lateinit var lastMatchPresenter: LastMatchesPresenter
    private var dataItemsLeague:ArrayList<ResponseModel?>? = null
    private var dataItemsEvents:ArrayList<ResponseModel?>? = null
    private lateinit var adapter:MatchSpinners
    private lateinit var adapterRecycler: MatchAdapters
    var idLeague:String = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_last_matches, container, false)

        val spin: Spinner = view.find(R.id.spinner_last_match)
        val recycler: RecyclerView = view.find(R.id.recycler_last_match)

        lastMatchPresenter = LastMatchesPresenter(this)
        dataItemsLeague = arrayListOf()
        dataItemsEvents = arrayListOf()

        adapter = MatchSpinners(context,dataItemsLeague)

        spin.adapter = adapter

        lastMatchPresenter.getLeague()

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                idLeague = dataItemsLeague!![position]!!.idLeague
                lastMatchPresenter.getEvents(idLeague)
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {}
        }

        //recycler
        dataItemsEvents = arrayListOf()
        val layout: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layout
        adapterRecycler = MatchAdapters(dataItemsEvents, context = context,param = 2) {
            startActivity<DetailActivityMatches>("id" to it.idEvent, "param" to "1")
        }
        recycler.adapter = adapterRecycler
        lastMatchPresenter.getEvents(idLeague)

        val search: EditText = view.find(R.id.search_last_match)
        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(edit: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, position: Int, p2: Int, p3: Int) {
                adapterRecycler.filter.filter(s.toString())
            }
        })

        return view
    }


}
