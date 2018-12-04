package com.example.sangs.finalprojectkade.matches.menu.menudetail

import com.example.sangs.finalprojectkade.Model.model.ResponseModel

interface DetailActivitysView {
    fun getMatchesSize(boolean: Boolean)
    fun setDataItems(dataModel:ResponseModel?, paramsIndex:String)
    fun setImageHome(homeBadge:String)
    fun setImageAway(awayBadge:String)

}