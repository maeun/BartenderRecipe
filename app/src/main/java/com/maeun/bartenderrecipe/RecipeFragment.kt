package com.maeun.bartenderrecipe

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.DialogFragment
import android.util.TypedValue
import android.view.Gravity
import kotlinx.android.synthetic.main.fragment_recipe.*
import android.widget.*
import android.content.Intent
import android.util.Log
import android.support.design.widget.Snackbar


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RecipeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RecipeFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        val window = dialog.window
        val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400f, resources.displayMetrics).toInt()
        window!!.setLayout(width, LinearLayout.LayoutParams.WRAP_CONTENT)
        window.setGravity(Gravity.CENTER)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val args = arguments

        dialog_name.setText(args!!.getString("name"))
        dialog_glass.setText(args!!.getString("glass"))
        dialog_method.setText(args!!.getString("method"))
        dialog_garnish.setText(args!!.getString("garnish"))

        var index = args!!.getInt("index")

        if ((activity as MainActivity).recipe[index].bookmark == 0) {
            bookmarkStar.setImageResource(R.drawable.star_empty)
        } else if ((activity as MainActivity).recipe[index].bookmark == 1) {
            bookmarkStar.setImageResource(R.drawable.star_full)
        }

        dialog_table.gravity = Gravity.CENTER_HORIZONTAL

        var _ratio = args!!.getParcelableArrayList<RatioData>("ratio")

        for (i in _ratio.indices) {

            val tr = TableRow(context)
            val lp = TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
            tr.setLayoutParams(lp);

            val _base = TextView(context)
            _base.text = _ratio[i].base // set the text for the header
            _base.setTextColor(Color.BLACK) // set the color
            _base.textAlignment = View.TEXT_ALIGNMENT_CENTER
            _base.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            _base.setPadding(30, 30, 200, 20)

            val _amount = TextView(context)
            _amount.text = _ratio[i].amount // set the text for the header
            _amount.setTextColor(Color.BLACK) // set the color
            _amount.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            _amount.setPadding(0, 0, 30, 0)
            _amount.textAlignment = View.TEXT_ALIGNMENT_TEXT_END

            tr.addView(_base)
            tr.addView(_amount)

            dialog_table.addView(tr, TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))
        }

        bookmarkStar.setOnClickListener {
            if ((activity as MainActivity).recipe[index].bookmark == 0) {
                bookmarkStar.setImageResource(R.drawable.star_full)
                (activity as MainActivity).recipe[index].bookmark = 1
                Snackbar.make(view!!, "북마크에 저장되었습니다", Snackbar.LENGTH_SHORT).show()
                (activity as MainActivity).bookmarkItems.add(BookmarkItem((activity as MainActivity).recipe[index].name,(activity as MainActivity).recipe[index].glass,(activity as MainActivity).recipe[index].method,(activity as MainActivity).recipe[index].garnish))
            } else if ((activity as MainActivity).recipe[index].bookmark == 1) {
                bookmarkStar.setImageResource(R.drawable.star_empty)
                (activity as MainActivity).recipe[index].bookmark = 0
                Snackbar.make(view!!, "북마크에서 해제되었습니다", Snackbar.LENGTH_SHORT).show()
                (activity as MainActivity).bookmarkItems.remove(BookmarkItem((activity as MainActivity).recipe[index].name,(activity as MainActivity).recipe[index].glass,(activity as MainActivity).recipe[index].method,(activity as MainActivity).recipe[index].garnish))
            }
        }

        dialog_video.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(args!!.getString("video"))
            startActivity(intent)
        }
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecipeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String) =
                RecipeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                        putString(ARG_PARAM3, param3)
                    }
                }
    }
}