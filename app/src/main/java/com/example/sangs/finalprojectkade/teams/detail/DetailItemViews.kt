package com.example.sangs.finalprojectkade.teams.detail

import com.example.sangs.finalprojectkade.Model.model.ResponseModel

interface DetailItemViews {
    fun getFavouriteSize(boolean: Boolean)
    fun showDataItems(dataItems: List<ResponseModel?>?)
}