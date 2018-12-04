package com.example.sangs.finalprojectkade.Model.db

class Teams (val id:Long?,
             val idTeam:String?,
             val strTeamBadge:String?,
             val strTeam:String?
) {

    companion object {
        const val TABLE_TEAMS: String = "TABLE_FAVORITE_TEAMS"
        const val id: String = "id"
        const val idTeam: String = "idTeam"
        const val strTeamBadge: String = "strTeamBadge"
        const val strTeam: String = "strTeam"

    }

}