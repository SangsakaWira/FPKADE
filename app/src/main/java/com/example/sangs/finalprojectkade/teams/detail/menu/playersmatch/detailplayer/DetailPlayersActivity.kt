package com.example.sangs.finalprojectkade.teams.detail.menu.playersmatch.detailplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.sangs.finalprojectkade.Model.model.ResponseModel
import com.example.sangs.finalprojectkade.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class DetailPlayersActivity : AppCompatActivity(), DetailPlayersView{

    override fun showPlayers(dataItems: List<ResponseModel?>?) {
        Picasso.get().load(dataItems!![0]!!.strThumb).placeholder(R.mipmap.ic_launcher).into(playerPhoto)
        playerWeight.text = dataItems[0]!!.strWeight
        playerheight.text = dataItems[0]!!.strHeight
        playerPosition.text = dataItems[0]!!.strPosition
        playerDesc.text = dataItems[0]!!.strDescriptionEN
        playerName.text =dataItems[0]!!.strPlayer
    }

    private lateinit var detailPlayersPresenter: DetailPlayersPresenter
    private lateinit var playerPhoto: ImageView
    private lateinit var playerWeight: TextView
    private lateinit var playerheight: TextView
    private lateinit var playerPosition: TextView
    private lateinit var playerDesc: TextView
    private lateinit var playerName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_players)

        val idPlayer:String = intent.getStringExtra("id")
        playerPhoto= find(R.id.player_detail_photo)
        playerWeight = find(R.id.player_detail_weight)
        playerheight = find(R.id.player_detail_height)
        playerPosition = find(R.id.player_detail_position)
        playerDesc = find(R.id.player_detail_desc)
        playerName = find(R.id.player_detail_name)

        detailPlayersPresenter = DetailPlayersPresenter(this)
        detailPlayersPresenter.getPlayers(idPlayer)

    }
}
