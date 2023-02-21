package com.example.flixster2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class Detail : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    // TODO: Find the views for the screen
    val movieImageView = findViewById<ImageView>(R.id.movie_image)
    val actorImageView = findViewById<ImageView>(R.id.actor_image)

    val actor = findViewById<TextView>(R.id.name)
    val known = findViewById<TextView>(R.id.known)
    val desc = findViewById<TextView>(R.id.description)

    // TODO: Get the extra from the Intent
    val mname = intent.getStringExtra("mname")
    val aname = intent.getStringExtra("aname")
    val murl = intent.getStringExtra("murl")
    val aurl = intent.getStringExtra("aurl")
    val des = intent.getStringExtra("des")

    // TODO: Set the title, byline, and abstract information from the article
    actor.text = aname
    known.text = mname
    desc.text = des
    // TODO: Load the media image
//    Glide.with(this)
//      .load(murl)
//      .into(movieImageView)

    Glide.with(this)
      .load(murl)
      .transform(CircleCrop())
      .into(movieImageView)

//    Glide.with(this)
//      .load(aurl)
//      .into(actorImageView)

    Glide.with(this)
      .load(aurl)
      .transform(CircleCrop())
      .into(actorImageView)
  }
}
