package com.example.sangs.finalprojectkade.matches.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.model.ResponseModel
import com.example.sangs.finalprojectkade.R

class MatchSpinners (val context: Context?, val dataItems: ArrayList<ResponseModel?>?): BaseAdapter() {

    val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemRowHolder
        if (convertView == null){
            view = mInflater.inflate(R.layout.spinner_layout, parent, false)
            vh = ItemRowHolder(view)
            view?.tag = vh
        }else{
            view = convertView
            vh = view.tag as ItemRowHolder
        }
        vh.label.text = dataItems?.get(position)?.strLeague
        return view
    }

    override fun getItem(position: Int): Any = dataItems?.get(position)!!

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = dataItems!!.size

    private class ItemRowHolder(row: View?) {
        val label: TextView
        init {
            this.label = row?.findViewById(R.id.spinner_tittle) as TextView
        }
    }
}