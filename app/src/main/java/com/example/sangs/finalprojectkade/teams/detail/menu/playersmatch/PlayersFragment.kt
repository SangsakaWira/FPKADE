package com.example.sangs.finalprojectkade.teams.detail.menu.playersmatch


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sangs.finalprojectkade.Model.model.ResponseModel

import com.example.sangs.finalprojectkade.R
import com.example.sangs.finalprojectkade.teams.detail.menu.playersmatch.detailplayer.DetailPlayersActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity

class PlayersFragment() : Fragment(),PlayersView{

    override fun getListPlayers(dataItems: List<ResponseModel?>?) {
        if (dataItems != null) {
            this.dataItems?.addAll(dataItems)
        }
        playersAdapter.notifyDataSetChanged()
    }

    private lateinit var id:String
    @SuppressLint("ValidFragment")
    constructor(id: String) : this() {
        this.id = id
    }

    private lateinit var playersPresenter: PlayersPresenter
    private lateinit var playersAdapter: PlayersAdapter
    private var dataItems: ArrayList<ResponseModel?>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_players, container, false)

        dataItems = arrayListOf()
        playersPresenter = PlayersPresenter(this)
        playersAdapter = PlayersAdapter(dataItems){
            startActivity<DetailPlayersActivity>("id" to it.idPlayer)
        }

        val recycler: RecyclerView = view.find(R.id.players_recycler)
        val layout: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layout
        recycler.adapter = playersAdapter

        playersPresenter.getDataPlayers(id)

        return view
    }


}
