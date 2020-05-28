package com.example.galleryapplication.data

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull

//Classe que faz a requisição à API coletando o json
class OkHttpRequest(client: OkHttpClient) {

    internal var client = OkHttpClient()

    init {
        this.client = client
    }

    // Criando o metodo http get que coleta o json, retornando um callback com a resposta da requisição
    fun GET(url: String, authorization : String, callback: Callback): Call {
        val request = Request.Builder()
            .url(url)
            .header("Authorization",authorization)
            .build()

        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }

    companion object {
        val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()
    }
}