package com.example.sangs.finalprojectkade.Model.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteTeam.db", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(Favorite.TABLE_FAVORITE, true,
            Favorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Favorite.idEvent to TEXT + UNIQUE,
            Favorite.strHomeTeam to TEXT,
            Favorite.strAwayTeam to TEXT,
            Favorite.dateEvent to TEXT,
            Favorite.intHomeScore to TEXT,
            Favorite.intAwayScore to TEXT,
            Favorite.TEAM_PARAMETER_ID to TEXT
            )

        db?.createTable(
            Teams.TABLE_TEAMS,true,
            Teams.id to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Teams.idTeam to TEXT+ UNIQUE,
            Teams.strTeamBadge to TEXT,
            Teams.strTeam to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(Favorite.TABLE_FAVORITE, true)
        db?.dropTable(Teams.TABLE_TEAMS, true)
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)