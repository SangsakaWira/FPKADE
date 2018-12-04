package com.example.sangs.finalprojectkade.favorite.menu.team

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.db.Teams
import com.example.sangs.finalprojectkade.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class FavoriteTeamsAdapter (
    val dataItems: ArrayList<Teams>,
    private val listener: (Teams) -> Unit):
    RecyclerView.Adapter<FavoriteTeamsAdapter.itemHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): itemHolder {
        return itemHolder(itemAdapterUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = dataItems.size

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        holder.bindItems(dataItems[position], Picasso.get(),listener)
    }

    class itemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var teamsTitle: TextView = itemView.find(R.id.teams_title)
        var teamsLogo: ImageView = itemView.find(R.id.teams_logo)

        fun bindItems(model: Teams, picasso: Picasso, listener: (Teams) -> Unit){
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
                        id = R.id.teams_logo
                        padding = dip(8)
                    }.lparams(width= 200,height = 200)
                    textView {
                        id = R.id.teams_title
                        padding = dip(8)
                        gravity = Gravity.CENTER
                    }.lparams(width= wrapContent,height = matchParent)
                }
            }
        }

    }
}