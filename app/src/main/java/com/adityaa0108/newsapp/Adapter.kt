package com.adityaa0108.newsapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide


class Adapter(private val context:Context,private val list:ArrayList<ModelClass> ) : RecyclerView.Adapter<Adapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mHeading:TextView = itemView.findViewById(R.id.mainheading)
        val mContent:TextView = itemView.findViewById(R.id.content)
        val mauthor:TextView = itemView.findViewById(R.id.author)
        val mtime:TextView = itemView.findViewById(R.id.time)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val cardView:CardView = itemView.findViewById(R.id.cardview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false)
        return ViewHolder(view)


    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {

        holder.cardView.setOnClickListener {
            val intent = Intent(context,webViewActivity::class.java)
              intent.putExtra("url",list.get(position).url)
            context.startActivity(intent)
        }
        holder.mtime.setText("Published At:-" + list.get(position).publishedAt)
        holder.mauthor.setText(list.get(position).author)
        holder.mHeading.setText(list.get(position).title)
        holder.mContent.setText(list.get(position).description)
        Glide.with(context).load(list.get(position).urlToImage).into(holder.imageView)


    }

    override fun getItemCount(): Int {
       return list.size
    }


}