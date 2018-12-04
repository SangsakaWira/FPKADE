package com.example.sangs.finalprojectkade.favorite.menu.match

import com.example.sangs.finalprojectkade.Model.db.Favorite
import com.example.sangs.finalprojectkade.Model.db.MyDatabaseOpenHelper
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FavoriteMatchesPresenterTest {

    @Mock
    private  lateinit var presenter:FavoriteMatchesPresenter

    @Mock
    private lateinit var view: FavoriteMatchesView

    @Mock
    private lateinit var databaseOpenHelper: MyDatabaseOpenHelper

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = FavoriteMatchesPresenter(view,databaseOpenHelper)
    }

    @Test
    fun getDataItemsFavourite() {
        var response:List<Favorite> = arrayListOf()
        Mockito.`when`(presenter.getDatabaseUse())
            .thenReturn(response)
        view.showDataItemsFavourite(response)
    }

}