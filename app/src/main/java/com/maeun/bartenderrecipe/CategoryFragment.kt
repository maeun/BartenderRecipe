package com.maeun.bartenderrecipe

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.view.*
import java.util.*


class CategoryFragment : Fragment(){

    val header : MutableList<String> = ArrayList()
    val body : MutableList<MutableList<String>> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_category, container, false)
        var expendedView : ExpandableListView ? = null
        expendedView = v.findViewById(R.id.expandableListView)

        header.add("Cocktail Glass")
        header.add("Old-fashioned Glass")
        header.add("Highball Glass")
        header.add("Footed Pilsner Glass")
        header.add("Collins Glass")
        header.add("etc.")

        val item1 : MutableList<String> = ArrayList()
        val item2 : MutableList<String> = ArrayList()
        val item3 : MutableList<String> = ArrayList()
        val item4 : MutableList<String> = ArrayList()
        val item5 : MutableList<String> = ArrayList()
        val item6 : MutableList<String> = ArrayList()

        for(i in MainActivity().recipe().indices) {
            if("Cocktail Glass" == MainActivity().recipe()[i].glass){
                item1.add(MainActivity().recipe()[i].name)
            }
            else if("Old-fashioned Glass" == MainActivity().recipe()[i].glass){
                item2.add(MainActivity().recipe()[i].name)
            }
            else if("Highball Glass" == MainActivity().recipe()[i].glass){
                item3.add(MainActivity().recipe()[i].name)
            }
            else if("Footed Pilsner Glass" == MainActivity().recipe()[i].glass){
                item4.add(MainActivity().recipe()[i].name)
            }
            else if("Collins Glass" == MainActivity().recipe()[i].glass){
                item5.add(MainActivity().recipe()[i].name)
            }
            else{
                item6.add(MainActivity().recipe()[i].name)
            }
        }

        body.add(item1)
        body.add(item2)
        body.add(item3)
        body.add(item4)
        body.add(item5)
        body.add(item6)

        v.expandableListView.setAdapter(ExpandableListAdapter(this.activity!!,expendedView,header,body,MainActivity().recipe()))

        return  v
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}