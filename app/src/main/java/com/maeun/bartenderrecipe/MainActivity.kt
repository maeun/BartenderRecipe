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
import android.util.Log
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

    var ratio = arrayListOf(
            //01~05
            arrayListOf(RatioData("Grenadine Syrup", "1/3 part"), RatioData("Crème de Menthe(Green)", "1/3 part"), RatioData("Brandy", "1/3 part")),
            arrayListOf(RatioData("Bourbon Whiskey", "1 1/2 oz"), RatioData("Sweet Vermouth", "3/4 oz"), RatioData("Angostura Bitters", "1 dash")),
            arrayListOf(RatioData("Dry Gin", "2 oz"), RatioData("Dry Vermouth", "1/3 oz")),
            arrayListOf(RatioData("Bourbon Whiskey", "1 1/2 oz"), RatioData("Cubed Sugar", "1 ea"), RatioData("Angostura Bitters", "1 dash"), RatioData("Soda Water", "1/2 oz")),
            arrayListOf(RatioData("Brandy", "3/4 oz"), RatioData("Crème de Cacao(Brown)", "3/4 oz"), RatioData("Light Milk", "3/4 oz")),
            //06~10
            arrayListOf(RatioData("Vodka", "1 1/2 oz"), RatioData("Worcestershire Sauce", "1 tsp"), RatioData("Tabasco Sauce", "3/4 oz"), RatioData("Salt and Pepper", "Pinch"), RatioData("Tomato Juice", "Fill")),
            arrayListOf(RatioData("Dry Gin", "1 1/2 oz"), RatioData("Lemon Juice", "1/2 oz"), RatioData("Powdered Sugar", "1 tsp"), RatioData("Soda Water", "Fill"), RatioData("Cherry Flavored Brandy", "1/2oz")),
            arrayListOf(RatioData("Vodka", "1 oz"), RatioData("Coffee Liqueur", "1/2 oz")),
            arrayListOf(RatioData("Tequila", "1 1/2 oz"), RatioData("Triple Sec", "1/2 oz"), RatioData("Lime Juice", "1/2 oz")),
            arrayListOf(RatioData("Scotch Whisky", "1 oz"), RatioData("Drambuie", "1/2 oz")),
            //11~15
            arrayListOf(RatioData("Bourbon Whiskey", "1 1/2 oz"), RatioData("Lemon Juice", "1/2 oz"), RatioData("Powdered Sugar", "1 tsp"), RatioData("Soda Water", "1 oz")),
            arrayListOf(RatioData("Bourbon Whiskey", "1 1/2 oz"), RatioData("Lime Juice", "1/2 oz"), RatioData("Powdered Sugar", "1 tsp"), RatioData("Grenadine Syrup", "1/2 tsp")),
            arrayListOf(RatioData("Vodka", "1 1/2 oz"), RatioData("Orange Juice", "Fill"), RatioData("Galliano", "1/2 oz")),
            arrayListOf(RatioData("Light Rum", "1 3/4 oz"), RatioData("Lime Juice", "3/4 oz"), RatioData("Powdered Sugar", "1 tsp")),
            arrayListOf(RatioData("Vodka", "1 oz"), RatioData("Sloe Gin", "1/2 oz"), RatioData("Dry Vermouth", "1/2 oz"), RatioData("Lemon Juice", "1 tsp")),
            //16~20
            arrayListOf(RatioData("Coffee Liqueur", "1/3 part"), RatioData("Bailey's Irish Cream Liqueur", "1/3 part"), RatioData("Grand Marnier", "1/3 part")),
            arrayListOf(RatioData("Midori(Melon Liqueur)", "1 oz"), RatioData("Coconut Flavored Rum", "1/2 oz"), RatioData("Banana Liqueur", "1/2 oz"), RatioData("Pineapple Juice", "2 oz"), RatioData("Sweet & Sour mix", "2 oz")),
            arrayListOf(RatioData("Bacardi Rum White", "1 3/4 oz"), RatioData("Lime Juice", "3/4 oz"), RatioData("Grenadine Syrup", "1 tsp")),
            arrayListOf(RatioData("Sole Gin", "1 1/2 oz"), RatioData("Lemon Juice", "1/2 oz"), RatioData("Powdered Sugar", "1 tsp"), RatioData("Soda Water", "Fill")),
            arrayListOf(RatioData("Light Rum", "1 1/2 oz"), RatioData("Lime Juice", "1/2 oz"), RatioData("Cola", "Fill")),
            //21~25
            arrayListOf(RatioData("Crème de Menthe(Green)", "1 oz"), RatioData("Crème de Cacao(White)", "1 oz"), RatioData("Light Milk", "1 oz")),
            arrayListOf(RatioData("Vodka", "1 1/2 oz"), RatioData("Cranberry Juice", "3 oz"), RatioData("Grapefruit Juice", "1/2 oz")),
            arrayListOf(RatioData("Vodka", "1 oz"), RatioData("Apple Pucker", "1 oz"), RatioData("Lime Juice", "1/2 oz")),
            arrayListOf(RatioData("Dry Gin", "3/4 oz"), RatioData("Sweet Vermouth", "3/4 oz"), RatioData("Campari", "3/4 oz")),
            arrayListOf(RatioData("Gin", "1/2 oz"), RatioData("Vodka", "1/2 oz"), RatioData("Light Rum", "1/2 oz"), RatioData("Tequila", "1/2 oz"), RatioData("Triple Sec", "1/2 oz"), RatioData("Sweet & Sour Mix", "1 1/2 oz"), RatioData("Cola", "Fill")),
            //26~30
            arrayListOf(RatioData("Brandy", "1 oz"), RatioData("Cointreau(or Triple Sec)", "1 oz"), RatioData("Lemon Juice", "1/4 oz")),
            arrayListOf(RatioData("Light Rum", "1 1/4 oz"), RatioData("Triple Sec", "3/4 oz"), RatioData("Lime Juice", "1 oz"), RatioData("Pineapple Juice", "1 oz"), RatioData("Orange Juice", "1 oz"), RatioData("Grenadine Syrup", "1/4 oz")),
            arrayListOf(RatioData("Light Rum", "1 1/4 oz"), RatioData("Pina Colada Mix", "2 oz"), RatioData("Pineapple Juice", "2 oz")),
            arrayListOf(RatioData("Vodka", "1 oz"), RatioData("Triple Sec", "1/2 oz"), RatioData("Lime Juice", "1/2 oz"), RatioData("Cranberry Juice", "1/2 oz")),
            arrayListOf(RatioData("Vodka", "1 1/2 oz"), RatioData("Lime Juice", "1/2 oz"), RatioData("Ginger ale", "Fill")),
            //31~35
            arrayListOf(RatioData("Apricot Flavored Brandy", "1 1/2 oz"), RatioData("Dry Gin", "1 tsp"), RatioData("Lemon Juice", "1/2 oz"), RatioData("Orange Juice", "1/2 oz")),
            arrayListOf(RatioData("Apple Brandy", "3/4 oz"), RatioData("Benedictine DOM", "3/4 oz"), RatioData("Triple Sec", "1/4 oz"), RatioData("Lemon Juice", "1/2 oz")),
            arrayListOf(RatioData("Light Rum", "1 oz"), RatioData("Blue Curacao", "1 oz"), RatioData("Coconut Flavored Rum", "1 oz"), RatioData("Pineapple Juice", "2 1/2 oz")),
            arrayListOf(RatioData("White Wine", "3 oz"), RatioData("Crème de Cassis", "1/2 oz")),
            arrayListOf(RatioData("Tequila", "1 1/2 oz"), RatioData("Orange Juice", "Fill"), RatioData("Grenadine Syrup", "1/2 oz")),
            //36~40
            arrayListOf(RatioData("Gam Hong Ro", "1 1/2 oz"), RatioData("Benedictine", "1/3 oz"), RatioData("Crème de Cassis", "1/3 oz"), RatioData("Sweet & Sour mix", "1 oz")),
            arrayListOf(RatioData("Jindo Hong Ju", "1 oz"), RatioData("Crème de Menthe White", "1/2 oz"), RatioData("White Grape Juice", "3/4 oz"), RatioData("Raspberry Syrup", "1/2 oz")),
            arrayListOf(RatioData("Andong Soju", "1 oz"), RatioData("Triple Sec", "1/3 oz"), RatioData("Apple Pucker", "1 oz"), RatioData("Lime Juice", "1/3 oz")),
            arrayListOf(RatioData("Geumsan Insamju", "1 1/2 oz"), RatioData("Coffee Liqueur", "1/2 oz"), RatioData("Apple Pucker", "1/2 oz"), RatioData("Lime Juice", "1 tsp")),
            arrayListOf(RatioData("Sunwoonsan bokbunja wine", "2 oz"), RatioData("Cointreau(or Triple Sec)", "1/2 oz"), RatioData("Sprite", "2 oz")))

    var recipe = mutableListOf<RecipeData>(
            //01~05
            RecipeData("Poussecafe", "Stemed Liqueur Glass", "Float", "", ratio[0], 0, "https://youtu.be/Qn2kN4j5aBw"),
            RecipeData("Manhattan", "Cocktail Glass", "Stir", "Cherry", ratio[1], 0, "https://youtu.be/3Z4UoRUKdcI"),
            RecipeData("Dry Martini", "Cocktail Glass", "Stir", "Green Olive", ratio[2], 0, "https://youtu.be/RBkvLOEPqwA"),
            RecipeData("Old Fashioned", "Old-fashioned Glass", "Build", "A Slice of Orange and Cherry", ratio[3], 0, "https://youtu.be/mycKEmhkj-E"),
            RecipeData("Brandy Alexander", "Cocktail Glass", "Shake", "Nutmeg Powder", ratio[4], 0, "https://youtu.be/9gelfaXaCME"),
            //06~10
            RecipeData("Bloody Mary", "Highball Glass", "Build", "A Slice of Lemon", ratio[5], 0, "https://youtu.be/PzNDi1_gs90"),
            RecipeData("Singapore Sling", "Footed Pilsner Glass", "Shake & Build", "A Slice of Orange and Cherry", ratio[6], 0, "https://youtu.be/ZSj4aftzSDg"),
            RecipeData("Black Russian", "Old-fashioned Glass", "Build", "", ratio[7], 0, "https://youtu.be/uX0WqTvdFZk"),
            RecipeData("Margarita", "Cocktail Glass", "Shake", "Rimming with Salt", ratio[8], 0, "https://youtu.be/4anQ-iAh3fE"),
            RecipeData("Rusty Nail", "Old-fashioned Glass", "Build", "", ratio[9], 0, "https://youtu.be/_VYBF1Di6PM"),
            //11~15
            RecipeData("Whiskey Sour", "Sour Glass", "Shake & Build", "A Slice of Lemon and Cherry", ratio[10], 0, "https://youtu.be/OO4aPgwE0-c"),
            RecipeData("New York", "Cocktail Glass", "Shake", "Twist of Lemon peel", ratio[11], 0, "https://youtu.be/2R6X8xh6aVQ"),
            RecipeData("Harvey Wallbanger", "Collins Glass", "Build & Float", "", ratio[12], 0, "https://youtu.be/HBz-7E3H4Ok"),
            RecipeData("Daiquiri", "Cocktail Glass", "Shake", "", ratio[13], 0, "https://youtu.be/YxV_oOJYtVs"),
            RecipeData("Kiss of Fire", "Cocktail Glass", "Shake", "Rimming with Sugar", ratio[14], 0, "https://youtu.be/JPnA_EmQMk8"),
            //16~20
            RecipeData("B-52", "Sherry Glass", "Float", "", ratio[15], 0, "https://youtu.be/X1_snYQJjFY"),
            RecipeData("June Bug", "Collins Glass", "Shake", "A Wedge of fresh Pineapple & Cherry", ratio[16], 0, "https://youtu.be/8mJDkvCKgLs"),
            RecipeData("Bacardi", "Cocktail Glass", "Shake", "", ratio[17], 0, "https://youtu.be/Yp0y3m7oq8A"),
            RecipeData("Sloegin Fizz", "Highball Glass", "Shake & Build", "A Slice of Lemon", ratio[18], 0, "https://youtu.be/VQy6MW9Pcks"),
            RecipeData("Cubalibre", "Highball Glass", "Build", "A Wedge of Lemon", ratio[19], 0, "https://youtu.be/T6fd3fHjz7A"),
            //21~25
            RecipeData("Grasshopper", "Saucer Champagne Glass", "Shake", "", ratio[20], 0, "https://youtu.be/Vm5J-tRdwOQ"),
            RecipeData("Sea Breeze", "Highball Glass", "Build", "A Wedge of Lemon", ratio[21], 0, "https://youtu.be/EuDqLyiOkRo"),
            RecipeData("Apple Martini", "Cocktail Glass", "Shake", "A Slice of Apple", ratio[22], 0, "https://youtu.be/WAasrRGOVEw"),
            RecipeData("Negroni", "Old-fashioned Glass", "Build", "Twist of Lemon peel", ratio[23], 0, "https://youtu.be/b6RITJdmPWM"),
            RecipeData("Long Island Ice Tea", "Collins Glass", "Build", "A Wedge of Lemon", ratio[24], 0, "https://youtu.be/MktCrcnJQ3s"),
            //26~30
            RecipeData("Sidecar", "Cocktail Glass", "Shake", "", ratio[25], 0, "https://youtu.be/tTlszhgecrU"),
            RecipeData("Maitai", "Footed Pilsner Glass", "Blend", "A Wedge of fresh Pineapple & Cherry", ratio[26], 0, "https://youtu.be/0LZAdSJyg-U"),
            RecipeData("Pinacolada", "Footed Pilsner Glass", "Blend", "A Wedge of fresh Pineapple & Cherry", ratio[27], 0, "https://youtu.be/gFx4JcNaS7s"),
            RecipeData("Cosmopolitan", "Cocktail Glass", "Shake", "Twist of Lemon peel", ratio[28], 0, "https://youtu.be/mLgRe5mthSI"),
            RecipeData("Moscowmule", "Highball Glass", "Build", "A Slice of Lemon", ratio[29], 0, "https://youtu.be/oQUbEIgF0hA"),
            //31~35
            RecipeData("Apricot", "Cocktail Glass", "Shake", "", ratio[30], 0, "https://youtu.be/ec162DKkwnw"),
            RecipeData("Honeymoon", "Cocktail Glass", "Shake", "", ratio[31], 0, "https://youtu.be/N9YlKUlakRY"),
            RecipeData("Blue Hawaiian", "Footed Pilsner Glass", "Blend", "A Wedge of fresh Pineapple & Cherry", ratio[32], 0, "https://youtu.be/m66XKwq61rI"),
            RecipeData("Kir", "White Wine Glass", "Build", "Twist of Lemon peel", ratio[33], 0, "https://youtu.be/XD9P7baEqX4"),
            RecipeData("Tequila Sunrise", "Footed Pilsner Glass", "Build & Float", "", ratio[34], 0, "https://youtu.be/6DOslLnSm-c"),
            //36~40
            RecipeData("Healing", "Cocktail Glass", "Shake", "Twist of Lemon peel", ratio[35], 0, "https://youtu.be/jO8Q-qVsFVU"),
            RecipeData("Jindo", "Cocktail Glass", "Shake", "", ratio[36], 0, "https://youtu.be/ZwX65Auj8R0"),
            RecipeData("Puppy Love", "Cocktail Glass", "Shake", "A Slice of Apple", ratio[37], 0, "https://youtu.be/FN__tYZtz80"),
            RecipeData("Geumsan", "Cocktail Glass", "Shake", "", ratio[38], 0, "https://youtu.be/59aQhwqVReE"),
            RecipeData("Gochang", "Flute Champagne Glass", "Stir & Build", "", ratio[39], 0, "https://youtu.be/YJ6Nr3uNRoQ"))

    lateinit var bookmarkItems : ArrayList<BookmarkItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookmarkItems = ArrayList()

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

    fun recipe(): MutableList<RecipeData> {
        return recipe
    }
}