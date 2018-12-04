package com.example.sangs.finalprojectkade.favorite.menu.match

import com.example.sangs.finalprojectkade.Model.db.Favorite
import com.example.sangs.finalprojectkade.Model.db.MyDatabaseOpenHelper
import kotlinx.coroutines.selects.select
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoriteMatchesPresenter(val view: FavoriteMatchesView,
                               val myDatabaseOpenHelper: MyDatabaseOpenHelper) {

    fun getDataItemsFavourite(){
        view.showDataItemsFavourite(getDatabaseUse())
    }

    fun getDatabaseUse():List<Favorite>{
        val data  = myDatabaseOpenHelper.use {
            val result = select(Favorite.TABLE_FAVORITE)
            result.parseList(classParser<Favorite>())
        }
        return data
    }

}