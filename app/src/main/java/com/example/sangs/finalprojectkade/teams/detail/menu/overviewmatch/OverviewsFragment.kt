package com.example.sangs.finalprojectkade.teams.detail.menu.overviewmatch


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.sangs.finalprojectkade.R
import org.jetbrains.anko.find


class OverviewsFragment() : Fragment() {

    private lateinit var id:String
    @SuppressLint("ValidFragment")
    constructor(id: String) : this() {
        this.id = id
    }

    private lateinit var overviewsPresenter: OverviewsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_overviews, container, false)

        val titleDesc: TextView = view.find(R.id.overview_desc)

        overviewsPresenter = OverviewsPresenter()
        overviewsPresenter.getInfoTeams(id,titleDesc)

        return view
    }


}
