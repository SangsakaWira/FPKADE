package com.example.sangs.finalprojectkade.matches.menu.menudetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.sangs.finalprojectkade.Model.model.ResponseModel
import com.example.sangs.finalprojectkade.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_matches.*

class DetailActivityMatches : AppCompatActivity(),DetailActivitysView{

    override fun setImageHome(homeBadge: String) {
        Picasso.get().load(homeBadge).placeholder(R.mipmap.ic_launcher).error(R.drawable.ic_error_black_24dp).into(detail_logo_home_team)
    }

    override fun setImageAway(awayBadge: String) {
        Picasso.get().load(awayBadge).placeholder(R.mipmap.ic_launcher).error(R.drawable.ic_error_black_24dp).into(detail_logo_away_team)
    }

    override fun setDataItems(dataModel: ResponseModel?, paramsIndex: String) {
        detail_name_away_team.text = dataModel?.strAwayTeam
        detail_name_home_team.text = dataModel?.strHomeTeam
        detail_date_event.text = dataModel?.dateEvent
        if (paramsIndex.equals("1")) {
            homeScore = dataModel?.intHomeScore.toString()
            awayScore = dataModel?.intAwayScore.toString()
            detail_score_team.text = "${dataModel?.intHomeScore} VS ${dataModel?.intAwayScore}"
            detail_goal_home_team.text = dataModel?.strHomeGoalDetails
            detail_goalkeeper_home_team.text = dataModel?.strHomeLineupGoalkeeper
            detail_defense_home_team.text = dataModel?.strHomeLineupDefense
            detail_midfield_home_team.text = dataModel?.strHomeLineupMidfield
            detail_forward_home_team.text = dataModel?.strHomeLineupForward
            detail_subtitutes_home_team.text = dataModel?.strHomeLineupSubstitutes
            detail_goal_away_team.text = dataModel?.strAwayGoalDetails
            detail_goalkeeper_away_team.text = dataModel?.strAwayGoalDetails
            detail_defense_away_team.text = dataModel?.strAwayLineupDefense
            detail_midfield_away_team.text = dataModel?.strAwayLineupMidfield
            detail_forward_away_team.text = dataModel?.strAwayLineupForward
            detail_subtitutes_away_team.text = dataModel?.strAwayLineupSubstitutes
            detail_shots_home_team.text = dataModel?.intHomeShots
            detail_shots_away_team.text = dataModel?.intAwayShots
        }
    }

    override fun getMatchesSize(boolean: Boolean) {

    }

    private var menuItem: Menu? = null
    private lateinit var id_item:String
    private lateinit var awayScore:String
    private lateinit var homeScore:String
    private lateinit var paramsIndex:String

    private var isFavorite: Boolean = false
    private lateinit var detailPresenter: DetailActivitysPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_matches)

        homeScore = ""
        awayScore = ""
        id_item = intent.getStringExtra("id")
        paramsIndex = intent.getStringExtra("param")

        detailPresenter = DetailActivitysPresenter(this)
//        detailPresenter.getFavoriteSize(id_item)

        detailPresenter.showDetailDataItems(id_item,paramsIndex)
    }

}
