package com.example.sangs.finalprojectkade.teams


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
import com.example.sangs.finalprojectkade.Model.model.ResponseModel
import com.example.sangs.finalprojectkade.Model.retrofit.APIClientRetrofit

import com.example.sangs.finalprojectkade.R
import org.jetbrains.anko.find

class TeamsFragment : Fragment(),TeamsView{

    override fun showLeague(dataItems: List<ResponseModel?>?) {

        if (dataItems != null) {
            this.dataItemsLeague?.addAll(dataItems)
        }

        adapterSpinner.notifyDataSetChanged()
    }

    override fun showTeams(dataItems: ArrayList<ResponseModel>) {

    }


    private lateinit var teamsPresenter: TeamsPresenter
    private lateinit var apiClient: APIClientRetrofit
    private var dataItemsLeague:ArrayList<ResponseModel?>? = null
    private lateinit var adapterSpinner:TeamsSpinner
    //    private lateinit var teamsAdapter: Teams
//    private lateinit var dataTeams:ArrayList<DataModel>
    private lateinit var loading: ProgressBar
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
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {}
        }

//        dataTeams = arrayListOf()
//        teamsAdapter = TeamsAdapter(dataTeams){
//            startActivity<DetailTeamsActivity>("id" to it.idTeam)
//        }
//        teamsPresenter.getDataTeams(context?.getString(R.string.url_allteams_league)+idLeague)
//        val layout: RecyclerView.LayoutManager = LinearLayoutManager(context)
//        recycler.layoutManager = layout
//        recycler.adapter = teamsAdapter
//
//        search.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(edit: Editable?) {
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, position: Int, p2: Int, p3: Int) {
//                teamsAdapter.filter.filter(s.toString())
//            }
//        })

        return view
    }


}
