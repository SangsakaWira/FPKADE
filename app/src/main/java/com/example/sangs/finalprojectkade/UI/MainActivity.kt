package com.example.sangs.finalprojectkade

import android.Manifest
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.example.sangs.finalprojectkade.favorite.FavoriteFragment
import com.example.sangs.finalprojectkade.matches.MatchesFragment
import com.example.sangs.finalprojectkade.teams.TeamsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainPresenter: MainPresenter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_matches -> {
                mainPresenter.changeFragment(MatchesFragment(),supportFragmentManager,R.id.frame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_teams -> {
                mainPresenter.changeFragment(TeamsFragment(),supportFragmentManager,R.id.frame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                mainPresenter.changeFragment(FavoriteFragment(),supportFragmentManager,R.id.frame)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR),10)
        }

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mainPresenter = MainPresenter()
        mainPresenter.changeFragment(MatchesFragment(),supportFragmentManager,R.id.frame)
    }
}
