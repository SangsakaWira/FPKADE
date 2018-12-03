package com.example.sangs.finalprojectkade.matches

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.sangs.finalprojectkade.R
import com.example.sangs.finalprojectkade.matches.menu.last.LastMatchesFragment
import com.example.sangs.finalprojectkade.matches.menu.next.NextMatchesFragment

class MatchesTab(fm: FragmentManager?, context: Context?): FragmentStatePagerAdapter(fm) {
    private val dataFragment = arrayOf(
        NextMatchesFragment(),
        LastMatchesFragment()
    )
    private val dataFragmentTittle = arrayOf(context?.getString(R.string.tab_next),context?.getString(R.string.tab_last))

    override fun getItem(position: Int): Fragment {
        return dataFragment[position]
    }

    override fun getCount(): Int = dataFragment.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> dataFragmentTittle[position]
            else -> dataFragmentTittle[position]

        }
    }
}