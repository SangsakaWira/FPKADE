package com.example.sangs.finalprojectkade.Model.api

import java.net.URL

object ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}