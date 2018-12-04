package com.example.sangs.finalprojectkade.favorite.menu.team

import com.example.sangs.finalprojectkade.Model.db.Teams

interface FavoriteTeamsView {
    fun showDataItemsFavourite(dataItems: List<Teams>)
}