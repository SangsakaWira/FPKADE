package com.example.sangs.finalprojectkade.favorite.menu.match


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sangs.finalprojectkade.Model.db.Favorite
import com.example.sangs.finalprojectkade.Model.db.database

import com.example.sangs.finalprojectkade.R
import org.jetbrains.anko.find


class FavoriteMatchesFragment : Fragment(), FavoriteMatchesView{

    override fun showDataItemsFavourite(dataItems: List<Favorite>) {
        this.dataItems.clear()
        this.dataItems.addAll(dataItems)
        adapter.notifyDataSetChanged()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FavoriteMatchesAdapter
    private lateinit var presenter: FavoriteMatchesPresenter
    private lateinit var dataItems: ArrayList<Favorite>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_favorite_matches, container, false)

        recyclerView = view.find(R.id.favourite_recycler_main)
        val layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        presenter = FavoriteMatchesPresenter(
            this,
            context!!.database
        )
        dataItems = ArrayList()

        adapter = FavoriteMatchesAdapter(
            dataItems,
            context
        )
        recyclerView.adapter = adapter

        presenter.getDataItemsFavourite()

        return view
    }


}
