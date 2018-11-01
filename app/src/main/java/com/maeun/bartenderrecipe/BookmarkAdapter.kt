package com.maeun.bartenderrecipe

import android.R.attr.fragment
import android.app.Activity
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.view.Gravity
import android.R.attr.gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.util.TypedValue
import android.hardware.usb.UsbDevice.getDeviceId
import android.widget.TextView


class BookmarkAdapter(var bookmarkItem: ArrayList<BookmarkItem>) : RecyclerView.Adapter<BookmarkViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val mainView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.bookmark_item, parent, false)
        return BookmarkViewHolder(mainView)
    }

    override fun getItemCount(): Int = bookmarkItem.size

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int, isUser: Boolean)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.cocktailName.text = bookmarkItem[position].cocktailName
        holder.glass.text = bookmarkItem[position].glass
        holder.method.text = bookmarkItem[position].method
        holder.garnish.text = bookmarkItem[position].garnish

        holder.bookmark.setOnClickListener {

            val snack = Snackbar.make(holder.bookmark.rootView!!, "북마크에서 해제되었습니다", Snackbar.LENGTH_LONG)
            val view = snack.getView()
            val params = view.getLayoutParams() as FrameLayout.LayoutParams

            val dip = 48f
            val px = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    dip,
                    holder.bookmark.resources.getDisplayMetrics()
            )

            params.setMargins(0, 0, 0, px.toInt())
            params.gravity = Gravity.BOTTOM

            view.setLayoutParams(params)
            snack.show()

            BookmarkFragment().delete(bookmarkItem[position].cocktailName, bookmarkItem[position].glass, bookmarkItem[position].method, bookmarkItem[position].garnish)

        }
    }
}