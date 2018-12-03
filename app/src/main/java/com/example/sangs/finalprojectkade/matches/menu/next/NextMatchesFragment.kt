package com.example.sangs.finalprojectkade.matches.menu.next


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
import android.widget.Spinner
import com.example.sangs.finalprojectkade.Model.model.ResponseModel

import com.example.sangs.finalprojectkade.R
import com.example.sangs.finalprojectkade.matches.menu.MatchAdapters
import com.example.sangs.finalprojectkade.matches.menu.MatchSpinners
import org.jetbrains.anko.find


class NextMatchesFragment : Fragment(),NextMatchViews {

    override fun showLeagues(dataItems: List<ResponseModel?>?) {
        if (dataItems != null) {
            this.dataItemsLeague?.addAll(dataItems)
        }
        adapter.notifyDataSetChanged()
    }

    override fun showEvents(dataItems: ArrayList<ResponseModel>) {

    }

    private lateinit var nextMatchPresenter: NextMatchesPresenter
    private var dataItemsLeague:ArrayList<ResponseModel?>? = null
    private lateinit var dataItemsEvents:ArrayList<ResponseModel>
    private lateinit var adapter: MatchSpinners
    private lateinit var adapterRecycler: MatchAdapters
    var idLeague:String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_next_matches, container, false)

        setHasOptionsMenu(true)

        val spinner: Spinner = view.find(R.id.spinner_next_match)

        dataItemsLeague = arrayListOf()
        nextMatchPresenter = NextMatchesPresenter(this)
        adapter = MatchSpinners(
            context,
            dataItemsLeague
        )
        spinner.adapter = adapter

        nextMatchPresenter.getLeague()
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
//                idLeague = dataItemsLeague[position].idLeague
//                nextMatchPresenter.getEventsLeagues(context?.getString(R.string.url_events_next_league)+idLeague)
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
            }
        }

        //recycler
//        val recyclerView: RecyclerView = view.find(R.id.recycler_next_match)
//        dataItemsEvents = arrayListOf()
//        val layout: RecyclerView.LayoutManager = LinearLayoutManager(context)
//        recyclerView.layoutManager = layout
//        adapterRecycler = MatchAdapters(dataItemsEvents, context = context,param = 1) {
////            startActivity<DetailActivity>("id" to it.idEvent, "param" to "2")
//        }
//        recyclerView.adapter = adapterRecycler
//        nextMatchPresenter.getEventsLeagues(context?.getString(R.string.url_events_next_league)+idLeague)
//
//        val search: EditText = view.find(R.id.search_next_match)
//        search.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(edit: Editable?) {
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, position: Int, p2: Int, p3: Int) {
//                adapterRecycler.filter.filter(s.toString())
//            }
//        })

        return view
    }


}
