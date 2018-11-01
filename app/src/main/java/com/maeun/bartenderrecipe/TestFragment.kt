package com.maeun.bartenderrecipe

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_test.*
import java.util.*
import kotlin.collections.ArrayList
import android.widget.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TestFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TestFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TestFragment : Fragment() {
    // TODO: Rename and change types of parameters

    var num_ = 0
    var recipe : MutableList<RecipeData> = MainActivity().recipe()
    var spinnerRatioId = ArrayList<Int>()

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var rand = random()

        text_cocktailName.setText(recipe[rand].name)

        random.setOnClickListener {
//            text_cocktailName.setText(recipe[rand].name)

            for(l in 0..spinnerRatioId.size-1)
                if(recipe[rand].ratio[l].amount != view!!.findViewById<Spinner>(spinnerRatioId[l]).selectedItem.toString()){
                    Toast.makeText(context,"다시 풀어보세요",Toast.LENGTH_SHORT).show()
                    break
                }
            Toast.makeText(context,"정답입니다",Toast.LENGTH_SHORT).show()
        }

        for(j in 1..recipe[rand].ratio.size) {
            val ll = LinearLayout(context)
            ll.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            ll.setBackgroundColor(Color.parseColor("#FFFF00"))
            ll.setOrientation(LinearLayout.HORIZONTAL);
//            ll.id = getResources().getIdentifier("btn_select_" + j, "id", getContext()!!.getPackageName());
            recipeLayout.addView(ll)

            val topTV1 = TextView(context)
            topTV1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            topTV1.setBackgroundColor(Color.parseColor("#00FFFFFF"))
            topTV1.setPadding(20, 10, 10, 10)
            topTV1.setTextColor(Color.parseColor("#FF7200"))
            topTV1.textSize = 13f
            topTV1.text = recipe[rand].ratio[j-1].base
            ll.addView(topTV1)

            var ratioOption = ArrayList<String>()
            ratioOption.add(recipe[rand].ratio[j - 1].amount)

            for(k in 1..3){
                var optionItem = recipe[Random().nextInt(recipe.size)].ratio[1].amount
                while(optionItem in ratioOption) {
                    optionItem = recipe[Random().nextInt(recipe.size)].ratio[1].amount
                }
                ratioOption.add(optionItem)
            }

            var seed = System.nanoTime();
            Collections.shuffle(ratioOption, Random(seed));

            val topTV2 = Spinner(context)
            topTV2.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            topTV2.setBackgroundColor(Color.parseColor("#00FFFFFF"))
            topTV2.setPadding(20, 10, 10, 10)

            val adapter = ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, ratioOption)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            topTV2.setSelection(0)
            topTV2.setId(j)
            spinnerRatioId.add(topTV2.id)
            topTV2.setAdapter(adapter)

            ll.addView(topTV2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    //0~39
    fun random(): Int{
        return Random().nextInt(recipe.size)
    }
}
