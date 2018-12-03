package com.example.sangs.finalprojectkade.teams.detail

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.sangs.finalprojectkade.R
import com.example.sangs.finalprojectkade.teams.detail.menu.overviewmatch.OverviewsFragment
import com.example.sangs.finalprojectkade.teams.detail.menu.playersmatch.PlayersFragment

class DetailTeamsAdapter (fm: FragmentManager?, context: Context?, id:String): FragmentStatePagerAdapter(fm) {

    val dataFragment = arrayOf(
        OverviewsFragment(id),
        PlayersFragment(id)
    )
    private val dataFragmentTittle =
        arrayOf(context?.getString(R.string.tab_overview), context?.getString(R.string.tab_players))

    override fun getItem(position: Int): Fragment {
        return dataFragment[position]
    }

    override fun getCount(): Int = dataFragment.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> dataFragmentTittle[position]
            else -> dataFragmentTittle[position]

        }
    }
}