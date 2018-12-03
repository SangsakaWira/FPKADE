package com.example.sangs.finalprojectkade.teams.detail.menu.playersmatch

import com.example.sangs.finalprojectkade.Model.model.ResponseModel

interface PlayersView {
    fun getListPlayers(dataItems: List<ResponseModel?>?)
}