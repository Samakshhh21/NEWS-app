package com.sampam.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class newsadapter(val context: Context,val list: List<article>):RecyclerView.Adapter<newsadapter.itemviewholder>() {

    class itemviewholder(itemView:View):RecyclerView.ViewHolder(itemView){
        val titletext:TextView=itemView.findViewById(R.id.titleview)
        val descriptiontext:TextView=itemView.findViewById(R.id.descriptionview)
        val image:ImageView=itemView.findViewById(R.id.imageView)
        val card=itemView.findViewById<CardView>(R.id.mycard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemviewholder {
        val itemview= LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return itemviewholder(itemview)
    }

    override fun onBindViewHolder(holder: itemviewholder, position: Int) {
        holder.titletext.text=list[position].title
        holder.descriptiontext.text=list[position].description
        Glide.with(context)
            .load(list[position].urlToImage)
            .into(holder.image)

        holder.card.setOnClickListener{
      val intent=Intent(context,current_news::class.java)
            intent.putExtra("image",list[position].urlToImage)
            intent.putExtra("title",list[position].title)
            intent.putExtra("content",list[position].content)
            startActivity(context,intent,null)
        }
    }
    override fun getItemCount(): Int =list.size
}