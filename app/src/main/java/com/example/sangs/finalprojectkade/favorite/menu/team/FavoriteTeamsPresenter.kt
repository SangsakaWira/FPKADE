package com.example.sangs.finalprojectkade.favorite.menu.team

import com.example.sangs.finalprojectkade.Model.db.MyDatabaseOpenHelper
import com.example.sangs.finalprojectkade.Model.db.Teams
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoriteTeamsPresenter(val favoriteTeamsView: FavoriteTeamsView,
                             val myDatabaseOpenHelper: MyDatabaseOpenHelper){

    fun getDataItemsFavourite(){
        favoriteTeamsView.showDataItemsFavourite(getDatabaseUse())
    }

    fun getDatabaseUse():List<Teams>{
        val data  = myDatabaseOpenHelper!!.use {
            val result = select(Teams.TABLE_TEAMS)
            result.parseList(classParser<Teams>())
        }
        return data
    }

}