package com.example.sangs.finalprojectkade.favorite.menu.team

import com.example.sangs.finalprojectkade.Model.db.MyDatabaseOpenHelper
import com.example.sangs.finalprojectkade.Model.db.Teams
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FavoriteTeamsPresenterTest {

    @Mock
    private  lateinit var presenter:FavoriteTeamsPresenter

    @Mock
    private lateinit var view: FavoriteTeamsView

    @Mock
    private lateinit var databaseOpenHelper: MyDatabaseOpenHelper

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = FavoriteTeamsPresenter(view,databaseOpenHelper)
    }

    @Test
    fun getDataItemsFavourite() {
        var response:List<Teams> = arrayListOf()
        Mockito.`when`(presenter.getDatabaseUse())
            .thenReturn(response)
        view.showDataItemsFavourite(response)
    }

}