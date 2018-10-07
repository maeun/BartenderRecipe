package com.maeun.bartenderrecipe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.net.Uri
import android.view.WindowManager
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_category.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), CategoryFragment.OnFragmentInteractionListener,
        BookmarkFragment.OnFragmentInteractionListener, TestFragment.OnFragmentInteractionListener,
        RecipeFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var recipe = arrayListOf<RecipeData>(
            //01~05
            RecipeData("Poussecafe", "Stemed Liqueur Glass", "Float", "", 0),
            RecipeData("Manhattan", "Cocktail Glass", "Stir", "Cherry", 0),
            RecipeData("Dry Martini", "Cocktail Glass", "Stir", "Green Olive", 0),
            RecipeData("Old Fashioned", "Old-fashioned Glass", "Build", "A Slice of Orange and Cherry", 0),
            RecipeData("Brandy Alexander", "Cocktail Glass", "Shake", "Nutmeg Powder", 0),
            //06~10
            RecipeData("Bloody Mary", "Highball Glass", "Build", "A Slice of Lemon or Celery", 0),
            RecipeData("Singapore Sling", "Footed Pilsner Glass", "Shake & Build", "A Slice of Orange and Cherry", 0),
            RecipeData("Black Russian", "Old-fashioned Glass", "Build", "", 0),
            RecipeData("Margarita", "Cocktail Glass", "Shake", "Rimming with Salt", 0),
            RecipeData("Rusty Nail", "Old-fashioned Glass", "Build", "", 0),
            //11~15
            RecipeData("Whiskey Sour", "Sour Glass", "Shake & Build", "A Slice of Lemon and Cherry", 0),
            RecipeData("New York", "Cocktail Glass", "Shake", "Twist of Lemon peel", 0),
            RecipeData("Harvey Wallbanger", "Collins Glass", "Build & Float", "", 0),
            RecipeData("Daiquiri", "Cocktail Glass", "Shake", "", 0),
            RecipeData("Kiss of Fire", "Cocktail Glass", "Shake", "Rimming with Sugar", 0),
            //16~20
            RecipeData("B-52", "Sherry Glass", "Float", "", 0),
            RecipeData("June Bug", "Collins Glass", "Shake", "A Wedge of fresh Pineapple & Cherry", 0),
            RecipeData("Bacardi", "Cocktail Glass", "Shake", "", 0),
            RecipeData("Sloegin Fizz", "Highball Glass", "Shake & Build", "A Slice of Lemon", 0),
            RecipeData("Cubalibre", "Highball Glass", "Build", "A Wedge of Lemon", 0),
            //21~25
            RecipeData("Grasshopper", "Saucer Champagne Glass", "Shake", "", 0),
            RecipeData("Sea Breeze", "Highball Glass", "Build", "A Wedge of Lime or Lemon", 0),
            RecipeData("Apple Martini", "Cocktail Glass", "Shake", "A Slice of Apple", 0),
            RecipeData("Negroni", "Old-fashioned Glass", "Build", "Twist of Lemon peel", 0),
            RecipeData("Long Island Ice Tea", "Collins Glass", "Build", "A Wedge of Lime or Lemon", 0),
            //26~30
            RecipeData("Sidecar", "Cocktail Glass", "Shake", "", 0),
            RecipeData("Maitai", "Footed Pilsner Glass", "Blend", "A Wedge of fresh Pineapple(Orange) & Cherry", 0),
            RecipeData("Pinacolada", "Footed Pilsner Glass", "Blend", "A Wedge of fresh Pineapple & Cherry", 0),
            RecipeData("Cosmopolitan", "Cocktail Glass", "Shake", "Twist of Lime or Lemon peel", 0),
            RecipeData("Moscowmule", "Highball Glass", "Build", "A Slice of Lime or Lemon", 0),
            //31~35
            RecipeData("Apricot", "Cocktail Glass", "Shake", "", 0),
            RecipeData("Honeymoon", "Cocktail Glass", "Shake", "", 0),
            RecipeData("Blue Hawaiian", "Footed Pilsner Glass", "Blend", "A Wedge of fresh Pineapple & Cherry",  0),
            RecipeData("Kir", "White Wine Glass", "Build", "Twist of Lemon peel", 0),
            RecipeData("Tequila Sunrise", "Footed Pilsner Glass", "Build & Float", "", 0),
            //36~40
            RecipeData("Healing", "Cocktail Glass", "Shake", "Twist of Lemon peel", 0),
            RecipeData("Jindo", "Cocktail Glass", "Shake", "", 0),
            RecipeData("Puppy Love", "Cocktail Glass", "Shake", "A Slice of Apple", 0),
            RecipeData("Geumsan", "Cocktail Glass", "Shake", "", 0),
            RecipeData("Gochang", "Flute Champagne Glass", "Stir & Build", "", 0))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        addFragment(CategoryFragment())


        main_tab.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.category_tab -> {
                    replaceFragment(CategoryFragment())
                }
                R.id.test_tab -> {
                    replaceFragment(TestFragment())
                }
                R.id.bookmark_tab -> {
                    replaceFragment(BookmarkFragment())
                }
            }
            true
        }
    }

    fun addFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_frame, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun recipe(): ArrayList<RecipeData> {
        return recipe
    }
}