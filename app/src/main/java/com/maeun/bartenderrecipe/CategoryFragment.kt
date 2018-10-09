package com.maeun.bartenderrecipe

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ExpandableListView
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.view.*
import java.util.*
import android.widget.AdapterView



class CategoryFragment : Fragment(){

    val header : MutableList<String> = ArrayList()
    val body : MutableList<MutableList<String>> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_category, container, false)

        val spinner = v.findViewById<Spinner>(R.id.main_spinner)
        spinner.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(spinner.selectedItem.toString() == "Glass"){
                    var expendedView : ExpandableListView ? = null
                    expendedView = v.findViewById(R.id.expandableListView)
                    v.expandableListView.setAdapter(ExpandableListAdapter(context!!,expendedView,header,body,MainActivity().recipe()))

                    header.removeAll { true }

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
                }
                else if(spinner.selectedItem.toString() == "Method"){
                    var expendedView : ExpandableListView ? = null
                    expendedView = v.findViewById(R.id.expandableListView)
                    v.expandableListView.setAdapter(ExpandableListAdapter(context!!,expendedView,header,body,MainActivity().recipe()))

                    header.removeAll { true }

                    header.add("Float")
                    header.add("Stir")
                    header.add("Build")
                    header.add("Shake")
                    header.add("Blend")
                    header.add("etc.")

                    val item1 : MutableList<String> = ArrayList()
                    val item2 : MutableList<String> = ArrayList()
                    val item3 : MutableList<String> = ArrayList()
                    val item4 : MutableList<String> = ArrayList()
                    val item5 : MutableList<String> = ArrayList()
                    val item6 : MutableList<String> = ArrayList()

                    for(i in MainActivity().recipe().indices) {
                        if("Float" == MainActivity().recipe()[i].method){
                            item1.add(MainActivity().recipe()[i].name)
                        }
                        else if("Stir" == MainActivity().recipe()[i].method){
                            item2.add(MainActivity().recipe()[i].name)
                        }
                        else if("Build" == MainActivity().recipe()[i].method){
                            item3.add(MainActivity().recipe()[i].name)
                        }
                        else if("Shake" == MainActivity().recipe()[i].method){
                            item4.add(MainActivity().recipe()[i].name)
                        }
                        else if("Blend" == MainActivity().recipe()[i].method){
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
                }
                else if(spinner.selectedItem.toString() == "Garnish"){
                    var expendedView : ExpandableListView ? = null
                    expendedView = v.findViewById(R.id.expandableListView)
                    v.expandableListView.setAdapter(ExpandableListAdapter(context!!,expendedView,header,body,MainActivity().recipe()))

                    header.removeAll { true }

                    header.add("가니쉬 없음")
                    header.add("A Slice of Apple")
                    header.add("A Slice of Lemon")
                    header.add("A Wedge of Lemon")
                    header.add("Twist of Lemon peel")
                    header.add("A Wedge of fresh Pineapple & Cherry")
                    header.add("etc.")

                    val item1 : MutableList<String> = ArrayList()
                    val item2 : MutableList<String> = ArrayList()
                    val item3 : MutableList<String> = ArrayList()
                    val item4 : MutableList<String> = ArrayList()
                    val item5 : MutableList<String> = ArrayList()
                    val item6 : MutableList<String> = ArrayList()
                    val item7 : MutableList<String> = ArrayList()

                    for(i in MainActivity().recipe().indices) {
                        if("" == MainActivity().recipe()[i].garnish){
                            item1.add(MainActivity().recipe()[i].name)
                        }
                        else if("A Slice of Apple" == MainActivity().recipe()[i].garnish){
                            item2.add(MainActivity().recipe()[i].name)
                        }
                        else if("A Slice of Lemon" == MainActivity().recipe()[i].garnish){
                            item3.add(MainActivity().recipe()[i].name)
                        }
                        else if("A Wedge of Lemon" == MainActivity().recipe()[i].garnish){
                            item4.add(MainActivity().recipe()[i].name)
                        }
                        else if("Twist of Lemon peel" == MainActivity().recipe()[i].garnish){
                            item5.add(MainActivity().recipe()[i].name)
                        }
                        else if("A Wedge of fresh Pineapple & Cherry" == MainActivity().recipe()[i].garnish){
                            item6.add(MainActivity().recipe()[i].name)
                        }
                        else{
                            item7.add(MainActivity().recipe()[i].name)
                        }
                    }
                    body.add(item1)
                    body.add(item2)
                    body.add(item3)
                    body.add(item4)
                    body.add(item5)
                    body.add(item6)
                    body.add(item7)
                }
                else{


                }
            }
        }



        return  v
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}