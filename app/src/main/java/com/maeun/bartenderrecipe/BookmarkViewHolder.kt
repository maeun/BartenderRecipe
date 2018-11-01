package com.maeun.bartenderrecipe

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class BookmarkViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var cocktailName : TextView = itemView!!.findViewById(R.id.bookmark_cocktailName) as TextView
    var glass : TextView = itemView!!.findViewById(R.id.bookmark_glass) as TextView
    var method : TextView = itemView!!.findViewById(R.id.bookmark_method) as TextView
    var garnish : TextView = itemView!!.findViewById(R.id.bookmark_garnish) as TextView
    var bookmark : ImageView = itemView!!.findViewById(R.id.bookmark_star) as ImageView
}