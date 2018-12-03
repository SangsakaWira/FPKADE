package com.example.sangs.finalprojectkade.teams.detail.menu.playersmatch

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.model.ResponseModel
import com.example.sangs.finalprojectkade.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class PlayersAdapter (
    var dataItems: ArrayList<ResponseModel?>?,
    private val listener: (ResponseModel) -> Unit):
    RecyclerView.Adapter<PlayersAdapter.itemHolder>(), AnkoLogger {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): itemHolder {
        return itemHolder(itemAdapterUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = dataItems!!.size

    override fun onBindViewHolder(holder: itemHolder, position: Int) {
        holder.bindItems(dataItems!![position]!!, Picasso.get(),listener)
    }

    class itemHolder(itemView: View) : RecyclerView.ViewHolder(itemView), AnkoLogger {
        var itemPhoto: ImageView = itemView.find(R.id.photo)
        var itemName: TextView = itemView.find(R.id.name)
        var itemPosition: TextView = itemView.find(R.id.position)
        fun bindItems(model: ResponseModel, picasso: Picasso, listener: (ResponseModel) -> Unit){
            picasso.load(model.strCutout).placeholder(R.mipmap.ic_launcher).into(itemPhoto)
            itemName.text = model.strPlayer
            itemPosition.text = model.strPosition
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
                        id = R.id.photo
                        padding = dip(8)
                    }.lparams(width= 200,height = 200)
                    textView {
                        id = R.id.name
                        padding = dip(8)
                        gravity = Gravity.CENTER
                    }.lparams(width= 0,height = matchParent, weight = 0.5f)
                    textView{
                        id = R.id.position
                        padding = dip(8)
                        gravity = Gravity.CENTER
                    }.lparams(width= 0,height = matchParent,weight = 0.5f)
                }
            }
        }

    }


}