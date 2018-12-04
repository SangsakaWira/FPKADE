package com.example.sangs.finalprojectkade.favorite.menu.match

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.db.Favorite
import com.example.sangs.finalprojectkade.R
import com.example.sangs.finalprojectkade.matches.menu.menudetail.DetailActivityMatches
import org.jetbrains.anko.*

class FavoriteMatchesAdapter (private val dataItems: ArrayList<Favorite>, private val context: Context?)
    : RecyclerView.Adapter<FavoriteMatchesAdapter.itemHolder>(), AnkoLogger {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): itemHolder {
        return itemHolder(
            itemAdapterUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun getItemCount(): Int = dataItems.size

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        holder.bindItem(dataItems[position])
        holder.linearLayout.setOnClickListener {
            context?.startActivity<DetailActivityMatches>("id" to dataItems[position].idEvent,"param" to dataItems[position].TEAM_PARAMETER_ID)
        }
    }

    class itemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val homeTeam: TextView = itemView.find(R.id.item_home)
        val scoreHomeTeam: TextView = itemView.find(R.id.item_home_score)
        val awayTeam: TextView = itemView.find(R.id.item_away)
        val scoreAwayTeam: TextView = itemView.find(R.id.item_away_score)
        val itemDate: TextView = itemView.find(R.id.item_tgl)
        val linearLayout: LinearLayout = itemView.find(R.id.item_linear)

        fun bindItem(favourite: Favorite) {
            homeTeam.text = favourite.strHomeTeam
            awayTeam.text = favourite.strAwayTeam
            itemDate.text = favourite.dateEvent
            scoreHomeTeam.text = favourite.intHomeScore
            scoreAwayTeam.text = favourite.intAwayScore
        }
    }

    //ItemViewUI
    class itemAdapterUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)

                    textView {
                        textSize = 10f
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }
                        textColor = Color.BLUE
                        id = R.id.item_tgl
                    }.lparams(width = matchParent, height =  wrapContent)

                    linearLayout {
                        lparams(width= matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL
                        padding = dip(8)
                        id = R.id.item_linear
                        textView {
                            textSize = 14f
                            id = R.id.item_home
                        }.lparams(width= 0,height = wrapContent, weight = 2f)
                        textView {
                            textSize = 14f
                            typeface = Typeface.DEFAULT_BOLD
                            id = R.id.item_home_score
                        }.lparams(width= 0,height = wrapContent, weight = 1f)

                        textView {
                            text = "VS"
                            textSize = 14f
                        }.lparams(width= 0,height = wrapContent, weight = 0.5f)

                        textView {
                            textSize = 14f
                            id = R.id.item_away_score
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams(width= 0,height = wrapContent, weight = 1f)
                        textView {
                            textSize = 14f
                            id = R.id.item_away
                        }.lparams(width= 0,height = wrapContent, weight = 2f)

                    }
                }

            }
        }

    }

}