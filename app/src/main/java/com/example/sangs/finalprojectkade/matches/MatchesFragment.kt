package com.example.sangs.finalprojectkade.matches


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sangs.finalprojectkade.R
import org.jetbrains.anko.find

/**
 * A simple [Fragment] subclass.
 *
 */
class MatchesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_matches, container, false)

        val tabs_main: TabLayout = view.find(R.id.tabs_matches)
        val pager: ViewPager = view.find(R.id.viewpager_matches)

        pager.adapter = MatchesTab(fragmentManager,context)
        tabs_main.setupWithViewPager(pager)

        return view
    }


}
