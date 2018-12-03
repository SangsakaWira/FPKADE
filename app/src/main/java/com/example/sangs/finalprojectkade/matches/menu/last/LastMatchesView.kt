package com.example.sangs.finalprojectkade.matches.menu.last

import com.example.sangs.finalprojectkade.Model.model.ResponseModel

interface LastMatchesView {

    fun showLeagues(dataItems: List<ResponseModel?>?)
    fun showEvents(dataItems: List<ResponseModel?>?)
}