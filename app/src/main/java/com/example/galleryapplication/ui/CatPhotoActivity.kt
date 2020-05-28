package com.example.galleryapplication.ui

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.galleryapplication.R
import com.squareup.picasso.Picasso


class CatPhotoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CAT_PHOTO = "CatPhotoActivity.EXTRA_CAT_PHOTO"
    }

    private lateinit var imageView: ImageView
    private lateinit var catPhoto: CatPhoto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_photo)

        catPhoto = intent.getParcelableExtra(EXTRA_CAT_PHOTO)
        imageView = findViewById(R.id.image)
    }

    override fun onStart() {
        super.onStart()

        Picasso.get()
            .load(catPhoto.url)
            .fit()
            .priority(Picasso.Priority.HIGH)
            .into(imageView)

        Picasso.get()
            .load(catPhoto.url)
            .fit()
            .priority(Picasso.Priority.LOW)
            .into(imageView)

        Picasso.get()
            .load(catPhoto.url)
            .fit()
            .priority(Picasso.Priority.NORMAL)
            .into(imageView)
    }
}