package com.example.sangs.finalprojectkade.teams

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.model.ResponseModel
import com.example.sangs.finalprojectkade.R

class TeamsSpinner (val context: Context?, val dataList: ArrayList<ResponseModel?>?): BaseAdapter() {

    val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val views: View
        val vh: ItemHolder
        if (convertView == null){
            views = mInflater.inflate(R.layout.spinner_layout, parent, false)
            vh = ItemHolder(views)
            views?.tag = vh
        }else{
            views = convertView
            vh = views.tag as ItemHolder
        }
        vh.label.text = dataList?.get(position)?.strLeague
        return views
    }

    override fun getCount(): Int = dataList!!.size

    override fun getItem(position: Int): Any = dataList?.get(position)!!

    override fun getItemId(position: Int): Long = position.toLong()

    private class ItemHolder(row: View?) {
        val label: TextView
        init {
            this.label = row?.findViewById(R.id.spinner_tittle) as TextView
        }
    }
}