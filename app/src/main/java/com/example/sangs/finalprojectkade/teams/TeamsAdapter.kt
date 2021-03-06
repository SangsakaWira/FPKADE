package com.example.sangs.finalprojectkade.teams

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.model.ResponseModel
import com.example.sangs.finalprojectkade.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class TeamsAdapter(
    var dataItems: ArrayList<ResponseModel?>?,
    private val listener: (ResponseModel) -> Unit):
    RecyclerView.Adapter<TeamsAdapter.itemHolder>(), Filterable {

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    dataItems = dataFiltered
                } else {
                    val filteredList = arrayListOf<ResponseModel?>()
                    for (row in dataFiltered!!) {

                        if (row?.strTeam?.toLowerCase()!!.contains(charString.toLowerCase())){
                            filteredList.add(row!!)
                        }
                    }
                    dataItems = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = dataItems
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                dataItems = filterResults.values as ArrayList<ResponseModel?>?
                notifyDataSetChanged()
            }
        }
    }

    val dataFiltered = dataItems

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): itemHolder {
        return itemHolder(itemAdapterUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = dataItems!!.size

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        holder.bindItems(dataItems!![position]!!, Picasso.get(),listener)
    }

    class itemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var teamsTitle: TextView = itemView.find(R.id.teams_titles)
        var teamsLogo: ImageView = itemView.find(R.id.teams_logos)

        fun bindItems(model: ResponseModel, picasso: Picasso, listener: (ResponseModel) -> Unit){
            teamsTitle.text = model.strTeam
            picasso.load(model.strTeamBadge).placeholder(R.mipmap.ic_launcher).into(teamsLogo)

            itemView.setOnClickListener { listener(model) }
        }
    }


    //ItemViewUI
    class itemAdapterUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(8)

                    imageView {
                        id = R.id.teams_logos
                        padding = dip(8)
                    }.lparams(width= 200,height = 200)
                    textView {
                        id = R.id.teams_titles
                        padding = dip(8)
                        gravity = Gravity.CENTER
                    }.lparams(width= wrapContent,height = matchParent)
                }
            }
        }

    }
}