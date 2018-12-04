package com.example.sangs.finalprojectkade.favorite.menu.match

import com.example.sangs.finalprojectkade.Model.db.Favorite

interface FavoriteMatchesView {
    fun showDataItemsFavourite(dataItems:List<Favorite>)
}