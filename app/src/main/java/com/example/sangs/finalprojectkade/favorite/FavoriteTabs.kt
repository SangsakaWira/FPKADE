package com.example.sangs.finalprojectkade.favorite

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.sangs.finalprojectkade.R
import com.example.sangs.finalprojectkade.favorite.menu.FavoriteMatchesFragment
import com.example.sangs.finalprojectkade.favorite.menu.FavoriteTeamsFragment

class FavoriteTabs (fm: FragmentManager?, context: Context?): FragmentStatePagerAdapter(fm) {

    val dataFragment = arrayOf(
        FavoriteMatchesFragment(),
        FavoriteTeamsFragment()
    )
    private val dataFragmentTittle = arrayOf(
        context?.getString(R.string.favourite_matches),
        context?.getString(R.string.favourite_teams)
    )

    override fun getItem(position: Int): Fragment {
        return dataFragment[position] as Fragment
    }

    override fun getCount(): Int = dataFragment.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> dataFragmentTittle[position]
            else -> dataFragmentTittle[position]

        }
    }

}
