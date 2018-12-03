package com.example.sangs.finalprojectkade.teams

import com.example.sangs.finalprojectkade.Model.model.ResponseModel

interface TeamsView {
    fun showLeague(dataItems: List<ResponseModel?>?)
    fun showTeams(dataItems: List<ResponseModel?>?)
}