package com.maeun.bartenderrecipe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.expandable_group.view.*
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.app.Activity
import android.support.v4.app.FragmentManager
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentActivity
import android.os.Bundle








class ExpandableListAdapter(var context: Context, var expandedView: ExpandableListView, var header: MutableList<String>, var body: MutableList<MutableList<String>>, var recipe : ArrayList<RecipeData>) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): String {
        return header[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.expandable_group, null)
        }
        val title = convertView!!.findViewById<TextView>(R.id.tv_group)
        title.text = getGroup(groupPosition)
        title?.setOnClickListener {
            if (expandedView.isGroupExpanded(groupPosition)) {
                expandedView.collapseGroup(groupPosition)
                //convertView!!.imageView.isPressed = false

            } else {
                expandedView.expandGroup(groupPosition)
                //convertView!!.imageView.isPressed = true
            }

        }
//        if (isExpanded) {
//            //title?.setCompoundDrawablesWithIntrinsicBounds(0, 0,R.drawable.ic_up, 0);
//            convertView.notice_arrow.isPressed = true  // 버튼클릭시 이미지 UP으로 변경
//        } else {
//            //title?.setCompoundDrawablesWithIntrinsicBounds(0, 0,R.drawable.ic_down, 0);
//            convertView.notice_arrow.isPressed = false // 버튼다시클릭시 이미지 Down으로  변경
//        }
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return body[groupPosition].size

    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return body[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {

        var convertView = convertView

        if (convertView == null) {

            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.expandable_item, null)
        }
        val title = convertView?.findViewById<TextView>(R.id.tv_item)
        title?.text = getChild(groupPosition, childPosition)
        title?.setOnClickListener {

            var name = title.text
            var glass = ""
            var method = ""
            var garnish = ""
            var ratio = ArrayList<RatioData>()

            for(i in recipe.indices){
                if(name == recipe[i].name){
                    glass = recipe[i].glass
                    method = recipe[i].method
                    garnish = recipe[i].garnish
                    ratio = recipe[i].ratio
                }
            }

            val activity = context as FragmentActivity
            val fm = activity.supportFragmentManager

            val args = Bundle()
            args.putString("name", name.toString())
            args.putString("glass", glass)
            args.putString("method", method)
            args.putString("garnish", garnish)
            args.putParcelableArrayList("ratio", ratio)

            val recipeFragment = RecipeFragment()
            recipeFragment.arguments = args
            recipeFragment.show(fm, "recipe")

            val builder = AlertDialog.Builder(context)
            builder.setTitle(title.text)
            builder.setMessage(recipe[0].toString())
            builder.setPositiveButton("닫기", null)
            builder.show()
        }

        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return header.size
    }
}