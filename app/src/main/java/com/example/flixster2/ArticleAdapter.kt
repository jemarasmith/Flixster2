package com.example.flixster2

import com.example.flixster2.Article
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.serialization.Serializable

const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
class ArticleAdapter(private val context : Context,private val articles: List<Article>) :
  RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val article = articles[position]

    holder.bind(article)
  }

  override fun getItemCount(): Int {
    return articles.size
  }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{

    private val mediaImageView = itemView.findViewById<ImageView>(R.id.actor)
    private val titleTextView = itemView.findViewById<TextView>(R.id.actor_name)

    init {
      itemView.setOnClickListener(this)
    }
    fun bind(article : Article){

      titleTextView.text = article.actor

      Glide.with(context)
        .load(article.actorimageURL)
        .into(mediaImageView)
    }
    override fun onClick(p0: View?) {
      val article = articles[absoluteAdapterPosition]
      val aname = article.actor
      val aurl = article.actorimageURL
      val descriptor = article.description
      val murl = article.movieImageUrl
      val mname = article.movieName

      val intent = Intent(context,Detail::class.java)

      intent.putExtra("aurl",aurl)
      intent.putExtra("murl",murl)
      intent.putExtra("des",descriptor)
      intent.putExtra("mname",mname)
      intent.putExtra("aname",aname)
      context.startActivity(intent)
    }

  }


}
