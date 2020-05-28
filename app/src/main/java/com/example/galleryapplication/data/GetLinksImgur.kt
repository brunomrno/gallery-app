package com.example.galleryapplication.data

import org.json.JSONObject

class GetLinksImgur {
    companion object {

        //Montando o arraylist com os links do json
        fun get(jsonObject: JSONObject): ArrayList<String> {

            var catsLinks = ArrayList<String>()
            var jsonArray = jsonObject.getJSONArray("data")

            for (i in 0 until jsonArray.length()) {
                val item = jsonArray[i] as JSONObject
                var imagesObject = JSONObject(item.toString())

                if (imagesObject.has("images")) {
                    var imagesArray = imagesObject.getJSONArray("images")

                    for (y in 0 until imagesArray.length()) {
                        val item2 = imagesArray[y] as JSONObject

                        if (item2.get("type").toString().contains("image")) {
                            if (item2.get("link").toString().isNotEmpty()) {
                                var link = item2.get("link").toString()
                                catsLinks.add(link)
                            }
                        }
                    }
                }
            }

            return catsLinks
        }
    }
}