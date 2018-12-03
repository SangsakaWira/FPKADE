package com.example.sangs.finalprojectkade.teams.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.ImageView
import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.model.ResponseModel
import com.example.sangs.finalprojectkade.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class DetailActivity : AppCompatActivity(),DetailItemViews{

    override fun getFavouriteSize(boolean: Boolean) {

    }

    override fun showDataItems(dataItems: List<ResponseModel?>?) {
        this.dataItems = dataItems as ArrayList<ResponseModel?>?
        Picasso.get().load(dataItems!![0]!!.strTeamBadge).placeholder(R.mipmap.ic_launcher).into(detailLogo)
        detailFormedYear.text = dataItems[0]!!.intFormedYear
        detailStadium.text = dataItems[0]!!.strStadium
        detailNameTeam.text = dataItems[0]!!.strTeam
    }

    private lateinit var detailTeamsPresenter: DetailItemPresenter
    private var isFavorite: Boolean = false
    private var dataItems:ArrayList<ResponseModel?>? = null
    private lateinit var detailLogo: ImageView
    private lateinit var detailFormedYear: TextView
    private lateinit var detailStadium: TextView
    private lateinit var detailNameTeam: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailLogo= find(R.id.detail_logo)
        detailFormedYear= find(R.id.detail_formed_year)
        detailStadium= find(R.id.detail_stadium)
        detailNameTeam= find(R.id.detail_name_team)
        val idTeams = intent.getStringExtra("id")

        dataItems = arrayListOf()

        detailTeamsPresenter = DetailItemPresenter(this)
        detailTeamsPresenter.getInformationTeams(idTeams)

        val tabs_main: TabLayout = find(R.id.tabs_main)
        val pager: ViewPager = find(R.id.viewpager_main)

        pager.adapter = DetailTeamsAdapter(supportFragmentManager,applicationContext,idTeams)
        tabs_main.setupWithViewPager(pager)
//
//        detailTeamsPresenter.getFavoriteSize(idTeams)
//
//        fab.setOnClickListener {
//            if (isFavorite) {
//                detailTeamsPresenter.removeFromFavorite(idTeams)
//                isFavorite = false
//            }
//            else{
//                detailTeamsPresenter.addToFavorite(
//                    idTeam = idTeams,
//                    teamLogo = dataItems[0].strTeamBadge,
//                    teamName = dataItems[0].strTeam
//                )
//                isFavorite = true
//            }
//            setFavorite()
//        }
//        setFavorite()
    }
}
