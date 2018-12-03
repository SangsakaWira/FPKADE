package com.example.sangs.finalprojectkade

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

class MainPresenter() {

    fun changeFragment(fragment: Fragment, fragmentManager: FragmentManager, id:Int){
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(id,fragment).commit()
    }

}