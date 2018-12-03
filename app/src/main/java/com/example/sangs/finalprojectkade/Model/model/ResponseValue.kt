package com.example.sangs.finalprojectkade.Model.model

import com.google.gson.annotations.SerializedName

class ResponseValue {

    @field:SerializedName("countrys")
    val countrys: List<ResponseModel?>? = null

    @field:SerializedName("teams")
    val teams: List<ResponseModel?>? = null

    @field:SerializedName("player")
    val player: List<ResponseModel?>? = null

    @field:SerializedName("events")
    val events: List<ResponseModel?>? = null

    @field:SerializedName("value")
    val value: Int? = null
}