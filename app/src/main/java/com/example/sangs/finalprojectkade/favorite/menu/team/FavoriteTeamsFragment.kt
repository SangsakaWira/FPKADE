package com.example.sangs.finalprojectkade.favorite.menu.team


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sangs.finalprojectkade.Model.db.Teams
import com.example.sangs.finalprojectkade.Model.db.database

import com.example.sangs.finalprojectkade.R
import com.example.sangs.finalprojectkade.teams.detail.DetailActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity


class FavoriteTeamsFragment : Fragment(), FavoriteTeamsView{

    override fun showDataItemsFavourite(dataItems: List<Teams>) {
        this.dataItems.clear()
        this.dataItems.addAll(dataItems)
        favouriteTeamsAdapter.notifyDataSetChanged()
    }

    private lateinit var favouriteTeamsAdapter: FavoriteTeamsAdapter
    private lateinit var favouriteTeamsPresenter: FavoriteTeamsPresenter
    private var dataItems:ArrayList<Teams> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_favorite_teams, container, false)

        val recycler: RecyclerView = view.find(R.id.favourite_recycler_main)

        favouriteTeamsPresenter = FavoriteTeamsPresenter(this,context!!.database)

        favouriteTeamsAdapter = FavoriteTeamsAdapter(dataItems){
            startActivity<DetailActivity>("id" to it.idTeam)
        }

        val layout: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layout
        recycler.adapter = favouriteTeamsAdapter

        favouriteTeamsPresenter.getDataItemsFavourite()

        return view
    }


}
