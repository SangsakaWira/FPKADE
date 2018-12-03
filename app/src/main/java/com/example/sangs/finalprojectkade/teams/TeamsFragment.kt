package com.example.sangs.finalprojectkade.teams


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
import com.example.sangs.finalprojectkade.teams.detail.DetailActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.find
import org.jetbrains.anko.info
import org.jetbrains.anko.support.v4.startActivity

class TeamsFragment : Fragment(),TeamsView,AnkoLogger{

    override fun showLeague(dataItems: List<ResponseModel?>?) {

        if (dataItems != null) {
            this.dataItemsLeague?.addAll(dataItems)
        }

        adapterSpinner.notifyDataSetChanged()
    }
    override fun showTeams(dataItems: List<ResponseModel?>?) {
        if (dataItems != null) {
            this.dataTeams?.addAll(dataItems)
        }

        teamsAdapter.notifyDataSetChanged()
    }

    private lateinit var teamsPresenter: TeamsPresenter
    private var dataItemsLeague:ArrayList<ResponseModel?>? = null
    private lateinit var adapterSpinner:TeamsSpinner
    private lateinit var teamsAdapter: TeamsAdapter
    private var dataTeams:ArrayList<ResponseModel?>? = null
    private lateinit var loading:ProgressBar
    private var idLeague:String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_teams, container, false)

        val spinner: Spinner = view.find(R.id.spinner_teams)
        val recycler: RecyclerView = view.find(R.id.recycler_teams)
        val search: EditText = view.find(R.id.search_teams)
        loading = view.find(R.id.loading)

        dataItemsLeague = arrayListOf()
        teamsPresenter = TeamsPresenter(this)
        adapterSpinner = TeamsSpinner(context,dataItemsLeague)
        teamsPresenter.getLeague()
        spinner.adapter = adapterSpinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                idLeague = dataItemsLeague!![position]!!.idLeague
                teamsPresenter.getData(idLeague)
            }
            override fun onNothingSelected(parentView: AdapterView<*>) {}
        }

        dataTeams = arrayListOf()
        teamsAdapter = TeamsAdapter(dataTeams){
            startActivity<DetailActivity>("id" to it.idTeam)
        }
        val layout: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layout
        recycler.adapter = teamsAdapter

        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(edit: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(s: CharSequence?, position: Int, p2: Int, p3: Int) {
                teamsAdapter.filter.filter(s.toString())
            }
        })
        return view
    }


}
