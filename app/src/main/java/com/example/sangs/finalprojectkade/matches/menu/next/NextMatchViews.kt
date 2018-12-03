package com.example.sangs.finalprojectkade.matches.menu.next

import com.example.sangs.finalprojectkade.Model.model.ResponseModel

interface NextMatchViews {
    fun showLeagues(dataItems: List<ResponseModel?>?)
    fun showEvents(dataItems: List<ResponseModel?>?)
}