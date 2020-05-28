package com.example.galleryapplication.ui

import android.os.Parcelable
import com.example.galleryapplication.data.GetLinksImgur
import com.example.galleryapplication.data.OkHttpRequest
import kotlinx.android.parcel.Parcelize
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException


@Parcelize
data class CatPhoto(val url: String) : Parcelable {

    companion object {
        fun getCatPhotos(): Array<CatPhoto> {

            //passando os dados para pegar os links usando o json
            var url = "https://api.imgur.com/3/gallery/search/?q=cats"
            var authorization = "Client-ID 1ceddedc03a5d71"

            var client = OkHttpClient()
            var request = OkHttpRequest(client)

            request.GET(url,authorization, object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    val responseData = response.body?.string()
                    val jsonObject = JSONObject(responseData)

                    var catLinks = GetLinksImgur.get(jsonObject)
                    return catLinks.forEach({
                        it
                    })
                }

                override fun onFailure(call: Call, e: IOException) {
                    println("Request Failure.")
                }
            })

            return emptyArray()
        }

    }
}