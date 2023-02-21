package com.example.flixster2

import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
class Article (title: String,poster_path : String, overview: String,name : String,actorURL:String){

  @SerializedName("title")
  var movieName = "Known for : $title"
  @SerializedName("poster_path")
  var movieImageUrl = "https://image.tmdb.org/t/p/w342/$poster_path"
  @SerializedName("overview")
  var description = overview
  @SerializedName("name")
  var actor = name
  @SerializedName("actorUrl")
  var actorimageURL = "https://image.tmdb.org/t/p/w342/$actorURL"
}
