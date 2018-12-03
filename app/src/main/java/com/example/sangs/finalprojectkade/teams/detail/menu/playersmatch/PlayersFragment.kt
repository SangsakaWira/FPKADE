package com.example.sangs.finalprojectkade.teams.detail.menu.playersmatch


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sangs.finalprojectkade.R

class PlayersFragment() : Fragment() {

    private lateinit var id:String
    @SuppressLint("ValidFragment")
    constructor(id: String) : this() {
        this.id = id
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_players, container, false)
    }


}
